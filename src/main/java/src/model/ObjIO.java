package src.model;

//import java.io.*;

import java.io.*;

public class ObjIO implements FileReadWrite {

    @Override
    public Serializable readFile(String aFileName) {   // throws IOException, ClassNotFoundException {
        Serializable aObj = null;
        // Востановление из файла с помощью класса ObjectInputStream

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(aFileName))) {
            aObj = (Serializable) objectInputStream.readObject();
//            System.out.println("Загрузка данных: успех !\nВаше семейное древо загружено !");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return aObj;
    }
    

    @Override
	public String writeFile(String aFileName, Serializable aObj){  // throws IOException, ClassNotFoundException

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(aFileName))) {
            objectOutputStream.writeObject(aObj);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return aFileName;
	}
}

