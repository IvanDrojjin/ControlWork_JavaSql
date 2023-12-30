package src.model;// https://gb.ru/lessons/344116

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AnimalTree<E extends Animal> implements Serializable, Iterable<E> {  // E inheritance Human
    private List <E> animalsTree;
    private String fileName;

    public void setFileName(String aFileName){
        this.fileName = aFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public AnimalTree() { animalsTree = new ArrayList<E>(); }  // constructor HumanTree

    public AnimalTree(List <E> aAnimalTree) {  // constructor HumanTree from List
        animalsTree = aAnimalTree;
    }
    
    public List <E> addAnimal(E aAnimal){  // merge HumanTree with  aList
        if(!animalsTree.contains(aAnimal)){  // only unigue aAnimal !!!
            animalsTree.add(aAnimal);
        }
        return animalsTree;
    }
    
    public List <E> addAnimalTree(List <E> aAnimalsTree){  // merge HumanTree with  aList
        for (E h: aAnimalsTree){
            this.addAnimal(h);
        }
        return animalsTree;
    }
    
    public List <E> getAnimals(){
        return animalsTree;
    }
    
    public String getFilename(){ return fileName; }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append(this.super.toString());
        if (fileName != null){
            stringBuilder.append("AnimalsTree (" + fileName + ")\n");
        } else {
            stringBuilder.append("AnimalsTree (файла нет)\n");
        }
        
        stringBuilder.append("Звери :\n");
        
        for (Animal h: animalsTree){
            stringBuilder.append(h);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    

    @Override
    public Iterator<E> iterator() {
        return new AnimalIterator<>(animalsTree);
    }

    public void sortByName(){
        animalsTree.sort(new AnimalComparatorByName<>());
    }

    public void sortByAge(){
        animalsTree.sort(new AnimalComparatorByAge<>());
    }


    public E getByName(String animalName) {
        for (E animal : animalsTree) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                return animal;
            }
        }
        return null;
    }

    public E getByNameDay(String animalName, LocalDate bd) {
        for (E animal : animalsTree) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                if (animal.getBirthDay().equalsIgnoreCase(bd.toString())){
                    return animal;
                }
            }
        }
        return null;
    }

}

