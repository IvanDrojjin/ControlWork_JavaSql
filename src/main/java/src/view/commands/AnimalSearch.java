package src.view.commands;
import src.view.ConsoleUI;
public class AnimalSearch  extends Command  {

    public AnimalSearch(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти животное ...";
    }
    @Override
    public void execute(){
        consoleUI.animalSearch();
    }
}
