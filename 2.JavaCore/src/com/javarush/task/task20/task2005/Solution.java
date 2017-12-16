package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
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

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);

            String isAssetsNotEmpty = this.assets.size() > 0 ? "yes" : "no";
            printWriter.println(isAssetsNotEmpty);

            if (this.assets.size() > 0) {
                for (Asset current : this.assets) {
                    String isNamePresent = current.getName() != null ? "yes" : "no";
                    printWriter.println(isNamePresent);

                    if (current.getName() != null)
                        printWriter.println(current.getName());

                    String isPricePresent = current.getPrice() > 0.0 ? "yes" : "no";
                    printWriter.println(isPricePresent);

                    if (current.getPrice() > 0.0)
                        printWriter.println(current.getPrice());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();

            String isAssetsNotEmpty = reader.readLine();

            if (isAssetsNotEmpty.equals("yes")) {
                this.assets = new ArrayList<>();
                while (reader.ready()) {
                    Asset asset;

                    String isNamePresent = reader.readLine();
                    asset = isNamePresent.equals("yes") ? new Asset(reader.readLine()) : new Asset(null);

                    String isPricePresent = reader.readLine();

                    if (isPricePresent.equals("yes"))
                        asset.setPrice(Double.valueOf(reader.readLine()));

                    this.assets.add(asset);
                }
            }
            reader.close();
        }
    }
}
