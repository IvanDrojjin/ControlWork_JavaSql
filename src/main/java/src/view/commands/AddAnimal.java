package src.view.commands;
import src.view.ConsoleUI;
public class AddAnimal extends Command {
    public AddAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить животное ...";
    }
    @Override
    public void execute(){
        consoleUI.addAnimal();
    }
}
