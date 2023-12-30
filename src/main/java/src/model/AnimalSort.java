package src.model;

import java.util.List;

public interface AnimalSort<E extends Animal>{
    void SortByName(List<E> al);

    void SortByAge(List <E> al);
}
