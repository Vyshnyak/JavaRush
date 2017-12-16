package com.javarush.task.task30.task3008;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();

        try(ServerSocket socket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                new Handler(socket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler (Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединения с удаленным адресом" + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            String name;
            while (true) {
                do {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    message = connection.receive();
                } while (message.getType() != MessageType.USER_NAME);

                name = message.getData();

                if (name.equals("") || connectionMap.containsKey(name)) {
                    continue;
                } else {
                    break;
                }
            }
            connectionMap.put(name, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                } else {
                    ConsoleHelper.writeMessage("Ошибка ввода.");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (String name : connectionMap.keySet()) {
            try {
                connectionMap.get(name).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не было отправлено.");
            }
        }
    }
}
