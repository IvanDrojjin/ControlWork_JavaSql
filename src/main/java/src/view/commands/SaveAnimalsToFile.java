package src.view.commands;
import src.view.ConsoleUI;

//import java.io.IOException;

public class SaveAnimalsToFile  extends Command {

    public SaveAnimalsToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл ...";
    }
    @Override
    public void execute() {consoleUI.SaveHumansToFile();}
}
