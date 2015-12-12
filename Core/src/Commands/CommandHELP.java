package Commands;

/**
 * Created by Сергей on 14.07.2015.
 */
public class CommandHELP extends Commands {

    @Override
    public String doCommand(String[] command) {
        if(!isCorrect(command))
            return "Command is incorrect. Send 'help' for see all commands";
        StringBuilder helpMessage = new StringBuilder();

        helpMessage.append("DATE - current date;\n");
        helpMessage.append("DIR - contents of a folder;");

        return helpMessage.toString();
    }

    @Override
    public boolean isCorrect(String[] command) {
        if(command.length > 1)
            return false;
        return true;
    }
}
