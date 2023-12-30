package src.view;

// import src.menu.MainMenu;

import src.model.AnimalType;
import src.model.Gender;
import src.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
//    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (menu.work()){
            printMenu();
            execute();
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan() {
        scanner = new Scanner(System.in, "Cp866");
        return scanner.nextLine();
    }

    public void finish() {
        System.out.println("Приятно было пообщаться...");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getAnimalsInfo() {
        presenter.getAnimalsInfo();
    }


    public LocalDate askBirthDay(){
        DateTimeFormatter formatterDt;
        String aPattern = "dd.MM.yyyy";
        formatterDt = DateTimeFormatter.ofPattern(aPattern);

        boolean dt_good = false; LocalDate lt = LocalDate.now();
        while (!dt_good){
            System.out.print(String.format( "Введите день рождения %s:", aPattern));
            String aBD = scanner.nextLine();
            lt = LocalDate.parse(aBD, formatterDt);
            try {  // https://www.programcreek.com/java-api-examples/?api=java.time.format.DateTimeParseException
                lt = LocalDate.parse(aBD, formatterDt);  dt_good = true;
            } catch (DateTimeParseException e) {
                System.out.print(e.getMessage());
                dt_good = false; lt = LocalDate.now();
            }
        }
        return lt;
    }

    public AnimalType askAnimalType(){
        AnimalType aAT = AnimalType.DOG;
        boolean at_good = false;
        String aInfo =
                "Введите породу  \n"+
                "0   DOG (собаки) \n" +
                "1   CAT (кошки) \n" +
                "2   HAMSTER (хомячки) \n" +
                "3   HORSE (лошади) \n" +
                "4   CAMEL (верблюды) \n" +
                "5   DONKEY (ослы) \n";

        /**
         *  0   DOG (собаки) \n
         *  1   CAT (кошки) \n
         *  2   HAMSTER (хомячки) \n
         *  3   HORSE (лошади) \n
         *  4   CAMEL (верблюды) \n
         *  5   DONKEY (ослы) \n
         *
         *
         *         String line = scanner.nextLine();
         *         if (checkTextForInt(line)){
         *             int numCommand = Integer.parseInt(line);
         *             if (checkCommand(numCommand)){
         *                 menu.execute(numCommand);
         *             }
         *         }
         * **/


        while (!at_good){
            System.out.print(aInfo);
            String line = scanner.nextLine();

            if (checkTextForInt(line)){
                int numCommand = Integer.parseInt(line);

                switch (numCommand) {
                    case 0:
                        aAT = AnimalType.DOG; //    "собаки";
                        at_good = true;
                        break;
                    case 1:
                        aAT = AnimalType.CAT; //    "кошки";
                        at_good = true;
                        break;
                    case 2:
                        aAT = AnimalType.HAMSTER; //  "хомячки";
                        at_good = true;
                        break;
                    case 3:
                        aAT = AnimalType.HORSE; //  "лошади";
                        at_good = true;
                        break;
                    case 4:
                        aAT = AnimalType.CAMEL; //  "верблюды";
                        at_good = true;
                        break;
                    case 5:
                        aAT = AnimalType.DONKEY; //  "ослы";
                        at_good = true;
                        break;
                }
            }
        }
        return aAT;
    }

    public void addAnimal() {
        Gender gSex = Gender.Man;
        AnimalType aAT = askAnimalType();
        DateTimeFormatter formatterDt;
        formatterDt = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.print("Введите имя животного :");
        String name = scanner.nextLine();

        System.out.print("Введите пол :");
        String aG = "м",   aGenderStr = scanner.nextLine();
        if (!aGenderStr.toLowerCase().contains("м")) {
            gSex = Gender.Femail;  // aG = "ж";
        }
        LocalDate lt = askBirthDay();

        presenter.addAnimal(name, null,  gSex, lt, aAT);
        // public void addAnimal(     String name,  +++
        //    List<String> skills,
        //    Gender aSex,   +++
        //    LocalDate aBD,   +++
        //    AnimalType aAnimalType )
    }


    public void animalSearch() {
        System.out.print("Введите имя животного для поиска-> ");
        String name = scan();
        presenter.humanSearch(name);
    }

    public void LoadAnimalsFromFile() {
        System.out.print("Введите имя Файла-> ");
        String fileName = scan();
        presenter.LoadAnimalsFromFile(fileName);
    }

    public void AppendAnimalsFromFile(){
        System.out.print("Введите имя Файла-> ");
        String fileName = scan();
        presenter.LoadAnimalsFromFile(fileName);
    }

    public void SaveHumansToFile() {  // throws IOException, ClassNotFoundException
        System.out.print("Введите имя Файла-> ");
        String fileName = scan();
        presenter.SaveAnimalsToFile(fileName);
    }

    private void hello(){
        System.out.println("\t Human Tree \nДоброго времени суток!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
        System.out.print("Выберите пункт Меню -> ");
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }



}
