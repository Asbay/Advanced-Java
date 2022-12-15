package Serialization;

import java.io.*;

public class Serielization_Deserialization {


    public static void main(String[] args) {

        //writeObjects();
        readObjects();


    }

    private static void writeObjects(){
        System.out.println("User Objeleri olusturuluyor");
        User user1 = new User(1L,"Yunus", "4567895678");
        User user2 = new User(1L,"Yusuf", "4513425678");
        User user3 = new User(1L,"Betül", "4324454224");

        try(FileOutputStream fos= new FileOutputStream("user.dat")){  //burada dosya yazmak icin hangi dosya yazilacak dosya ismi onu söylüyorum
         try(   ObjectOutputStream oos= new ObjectOutputStream(fos)){ //bu objeleri yazmak icin
             oos.writeObject(user1);
             oos.writeObject(user2);
             oos.writeObject(user3);
         }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readObjects(){
// Java da File islemlerinde okuma islemi yaparken FileInputStream class i kullanilir.

        try(FileInputStream fis = new FileInputStream("user.dat")){ // Okunacak dosya belirleniyor
            try(ObjectInputStream ois = new ObjectInputStream(fis)){ // Obje olarak okunacak
                User user1 = (User)ois.readObject();
                User user2 = (User)ois.readObject();
                User user3 = (User)ois.readObject();

                System.out.println(user1);
                System.out.println(user2);
                System.out.println(user3);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

    class User implements Serializable {

            private  Long id;
            private  String name;
            private String tcKimlikNo;

        public User(Long id, String name, String tcKimlikNo) {
            this.id = id;
            this.name = name;
            this.tcKimlikNo = tcKimlikNo;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTcKimlikNo() {
            return tcKimlikNo;
        }

        public void setTcKimlikNo(String tcKimlikNo) {
            this.tcKimlikNo = tcKimlikNo;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", tcKimlikNo='" + tcKimlikNo + '\'' +
                    '}';
        }
    }


