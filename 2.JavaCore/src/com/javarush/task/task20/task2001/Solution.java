package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001\\test");
            InputStream inputStream = new FileInputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001\\test");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter fileWriter = new PrintWriter(outputStream);

            String isNamePresent = name != null ? "yes" : "no";
            fileWriter.println(isNamePresent);

            if (name != null)
                fileWriter.println(name);

            String isAssetsPresent = !assets.isEmpty() ? "yes" : "no";
            fileWriter.println(isAssetsPresent);

            if (!assets.isEmpty()) {
                for (Asset asset : assets) {
                    fileWriter.println(asset.getName());
                    fileWriter.println(asset.getPrice());
                }
            }
            fileWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));

            String isNamePresent = fileReader.readLine();

            if (isNamePresent.equals("yes"))
                name = fileReader.readLine();

            String isAssetsPresent = fileReader.readLine();

            if (isAssetsPresent.equals("yes")) {
                assets = new ArrayList<>();
                while (fileReader.ready()) {
                    Asset asset = new Asset(fileReader.readLine());
                    asset.setPrice(Double.parseDouble(fileReader.readLine()));
                    assets.add(asset);
                }
            }
        }
    }
}
