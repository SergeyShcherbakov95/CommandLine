package Commands;

import java.util.Date;

/**
 * Created by Сергей on 14.07.2015.
 */
public class CommandDATE extends Commands {

    @Override
    public String doCommand(String[] command) {
        if(!isCorrect(command))
            return "Command is incorrect. Send 'help' for see all commands";
        return new Date().toString();
    }

    @Override
    public boolean isCorrect(String[] command) {
        if(command.length > 1)
            return false;
        return true;
    }
}
