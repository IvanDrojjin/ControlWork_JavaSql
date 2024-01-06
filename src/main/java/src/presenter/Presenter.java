package src.presenter;

import src.model.*;
import src.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;

    private ObjIO serialize;

    private AnimalComparatorByAge sortAge;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public Presenter(View view, AnimalTree<Animal> familyConnect, ObjIO serialize, AnimalComparatorByAge sortAge) {
//        this.humansTreeConnect = familyConnect;
        this.view = view;
        this.service = new Service(familyConnect);
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addAnimal(String name, String skills, Gender aSex,
                          LocalDate aBD, AnimalType aAnimalType) {  // String name, String sex, int age
        service.addAnimal(name, skills, aSex, aBD, aAnimalType);

    }


    public void getAnimalsInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        view.printAnswer(service.getTreeInfo());
    }

    public void sortByName() {
        service.sortByName();
        view.printAnswer(service.getTreeInfo());
    }

    public void  LoadAnimalsFromFile(String fileName) {
        view.printAnswer("LoadAnimalsFromFile...");
        service.loadFromFile(fileName);
    }

    public void  SaveAnimalsToFile(String fileName)   {   // throws IOException, ClassNotFoundException
        view.printAnswer("SaveAnimalsToFile...");
        service.saveToFile(fileName);
    }

    public void humanSearch(String name) {
        view.printAnswer(service.humanSearch(name));
    }

}
