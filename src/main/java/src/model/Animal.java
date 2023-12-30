package src.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Animal implements Serializable {
    private String name;
    private List <String> skills;  // List --> Set for unigue
    private LocalDate birthDay; //, deathDay день рождения, дата смерти
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
    private Gender gender; // пол
    private AnimalType animalType;  // вид
    public Animal(String aName, List<String> skills,
                  Gender aGender, LocalDate aBirthDay, AnimalType aAnimalType)   {
        this.name = aName;
        this.skills = skills;
        this.gender = aGender;
        this.birthDay = aBirthDay;
        this.animalType = aAnimalType;
    }  // constructor Animal

    public Gender getGender(){      return gender;    }

    public String getName(){
        return name;
    }

    public String getBirthDay(){
        return birthDay.toString();
    }

    public LocalDate getBirthDayO(){  // LocalDate fbirthDay
        return birthDay;
    }

    public AnimalType getAnimalType(){  // LocalDate fbirthDay
        return animalType;
    }

    // public String getAnimalType() { return animalType.toString(); }

    @Override
    public String toString() {
        String str0 = "\"имя : \" + name + \",\\t д.р. : \" + birthDay + \",\\t пол : \" + gender";

        return "имя : " + name + ",\t д.р. : " + birthDay + ",\t пол : " + gender;
    }
    
    @Override
    public boolean equals(Object obj){
    	if (this == obj){return true;}
    	if (!(obj instanceof Animal)){return false;}
        Animal ahM = (Animal) obj;
    	return (name.equals(ahM.name) && // имя
    		birthDay.toString().equals(ahM.birthDay.toString()) &&  // день рождения  LocalDate.of(...).toString().equals()
    		gender == ahM.gender);  // пол
    }

    @Override
    public int hashCode(){
    	return name.hashCode()
    		+ 3 * birthDay.hashCode()
    		+ 5 * gender.hashCode();
    }
    
}