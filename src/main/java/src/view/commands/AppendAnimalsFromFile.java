package src.view.commands;
import src.view.ConsoleUI;

public class AppendAnimalsFromFile  extends Command {

    public AppendAnimalsFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить из файла ...";
    }
    @Override
    public void execute() {consoleUI.AppendAnimalsFromFile();}
}
