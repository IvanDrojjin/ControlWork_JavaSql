package src.model;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Service {

    private AnimalTree animalTree;
    private String fileName;

    public Service() {
        animalTree = new AnimalTree();
    }

    public Service(AnimalTree<Animal> familyConnect) {
        animalTree = familyConnect;
    }

    public void addAnimal(String aName, List<String> skills,
                          Gender aSex, LocalDate aBirthDay, AnimalType aAnimalType){
        Animal aAnimal = new Animal(aName, skills, aSex, aBirthDay, aAnimalType);
        animalTree.addAnimal(aAnimal);
    }
//  Animal(String aName, List<String> skills,
//                  Gender aGender, LocalDate aBirthDay, AnimalType aAnimalType)

    public Animal humanFind(String name, LocalDate bd) {
        Animal human = animalTree.getByNameDay (name, bd);  ///  (String name, LocalDate bd)
        return human;
    }

    public  String loadFromFile(String fileName) {
        AnimalTree aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjIO aIO = new ObjIO();
        aHT = (AnimalTree) aIO.readFile(fileName);

        animalTree = aHT;
        animalTree.setFileName(fileName);
        return "AnimalTree load from " + fileName;
    }

    public  String addFromFile(String fileName)  throws IOException, ClassNotFoundException    {
        AnimalTree aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjIO aIO = new ObjIO();
        aHT =  (AnimalTree) aIO.readFile(fileName);   //

        animalTree.addAnimalTree(aHT.getAnimals());
        animalTree.setFileName(fileName);
        return "AnimalTree add from " + fileName;
    }

    public  String  saveToFile(String fileName) {

        ObjIO aIO = new ObjIO();
        aIO.writeFile(fileName, (Serializable) animalTree);

        animalTree.setFileName(fileName);
        return "AnimalTree save to " + fileName;
    }

    public String humanSearch(String name) {
        Animal human = animalTree.getByName(name);
        if (human == null)
            return "Такого человека нет в семье !";
        else {
            return human.toString();
        }
    }


    public  Animal getByNameDay(String name, LocalDate bd){
        return animalTree.getByNameDay (name, bd);
    }

    public  Animal  getByName(String name) {
        return animalTree.getByName (name);
    }

    public String getTreeInfo() {
        return animalTree.toString();
    }
    public void sortByName(){
        animalTree.sortByName();
    }

    public void sortByAge(){
        animalTree.sortByAge();
    }
}
