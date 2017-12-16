package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\test");
            InputStream inputStream = new FileInputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\test");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Max");
            user.setLastName("Vyshnyak");
            user.setBirthDate(new Date(91, 11, 30));
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);

            User user1 = new User();
            user1.setFirstName("Igor");
            user1.setLastName("Dyrdiev");
            user1.setBirthDate(new Date(91, 6, 30));
            user1.setMale(false);
            user1.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            System.out.println(javaRush.hashCode());
            System.out.println(loadedObject.hashCode());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            String isUsersNotEmpty = !users.isEmpty() ? "yes" : "no";
            writer.println(isUsersNotEmpty);

            if (!users.isEmpty()) {
                //writer.println(users.size());
                for (User user : users) {
                    String isFirstNamePresent = user.getFirstName() != null ? "yes" : "no";
                    writer.println(isFirstNamePresent);

                    if (user.getFirstName() != null)
                        writer.println(user.getFirstName());

                    String isLastNamePresent = user.getLastName() != null ? "yes" : "no";
                    writer.println(isLastNamePresent);

                    if (user.getLastName() != null)
                        writer.println(user.getLastName());

                    String isBirthDatePresent = user.getBirthDate() != null ? "yes" : "no";
                    writer.println(isBirthDatePresent);

                    if (user.getBirthDate() != null) {
                        writer.println(user.getBirthDate().getTime());
                    }

                    String isMale = user.isMale() ? "yes" : "no";
                    writer.println(isMale);

                    if (user.isMale())
                        writer.println(user.isMale());

                    String isCountryPresent = user.getCountry() != null ? "yes" : "no";
                    writer.println(isCountryPresent);

                    if (user.getCountry() != null)
                        writer.println(user.getCountry().getDisplayedName());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isUsersNotEmpty = reader.readLine();

            if (isUsersNotEmpty.equals("yes")) {
                while (reader.ready()) {
                    User newUser = new User();

                    String isFirstNamePresent = reader.readLine();

                    if (isFirstNamePresent.equals("yes"))
                        newUser.setFirstName(reader.readLine());

                    String isLastNamePresent = reader.readLine();

                    if (isLastNamePresent.equals("yes"))
                        newUser.setLastName(reader.readLine());

                    String isBirthDatePresent = reader.readLine();

                    if (isBirthDatePresent.equals("yes")) {
                        newUser.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    }

                    String isMale = reader.readLine();

                    if (isMale.equals("yes"))
                        newUser.setMale(Boolean.valueOf(reader.readLine()));

                    String isCountryPresent = reader.readLine();

                    if (isCountryPresent.equals("yes")) {
                        String country = reader.readLine();
                        if (country.equals(User.Country.UKRAINE.getDisplayedName()))
                            newUser.setCountry(User.Country.UKRAINE);
                        else if (country.equals(User.Country.RUSSIA.getDisplayedName()))
                            newUser.setCountry(User.Country.RUSSIA);
                        else
                            newUser.setCountry(User.Country.OTHER);
                    }
                    users.add(newUser);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
