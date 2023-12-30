package src.view.commands;
import src.view.ConsoleUI;
public class LoadAnimalsFromFile  extends Command {
    public LoadAnimalsFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла ...";
    }
    @Override
    public void execute(){consoleUI.LoadAnimalsFromFile();}
}
