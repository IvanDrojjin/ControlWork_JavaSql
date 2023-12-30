package src.model;// https://gb.ru/lessons/344116

//  https://yandex.ru/search/?clid=9582&text=java+enum+to+string&l10n=en-US&lr=213
//  java enum to string

public enum AnimalType {
     /**
     * 'dogs`       собаки
     * `hamsters`   хомячки
     * `horses`     лошади
     * `camels`     верблюды
     * `donkeys`    ослы
     **/

    DOG, // собаки
    CAT, // кошки
    HAMSTER, // хомячки
    HORSE,  // лошади
    CAMEL,  // верблюды
    DONKEY  // ослы
    ;  // ...  String CONNST
    
    @Override
    public String toString() {
        String rStr ;
        switch (this) {
            case DOG:  { rStr =  "собаки";};  break;
            case CAT:  { rStr =  "кошки";};  break;
            case HAMSTER:  { rStr =  "хомячки";};  break;
            case HORSE:  { rStr =  "лошади";};  break;
            case CAMEL:  { rStr =  "верблюды";};  break;
            case DONKEY:  { rStr =  "ослы";};  break;
            default:   { rStr =  "??? ослы ???";};  break;
        }
        return rStr;
    }
}