package src.view.commands;
import src.view.ConsoleUI;

public class GetAnimalsInfo  extends Command {

    public GetAnimalsInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести животныx ...";
    }
    @Override
//    public void execute(){getConsole().addHumanNew();}
    public void execute(){consoleUI.getAnimalsInfo();}
}
