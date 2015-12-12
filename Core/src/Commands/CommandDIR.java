package Commands;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Сергей on 14.07.2015.
 */
public class CommandDIR extends Commands {
    @Override
    public String doCommand(String[] command) {
        StringBuilder filePath = new StringBuilder();
        for(int i = 1; i < command.length; i++ ) {
            if (i == command.length - 1) {
                filePath.append(command[i]);
                continue;
            }
            filePath.append(command[i] + " ");
        }
        String[] strings = {filePath.toString()};
        if(!isCorrect(strings))
            return "Command is incorrect. Send 'help' for see all commands";
        File file = new File(filePath.toString());
        return Arrays.toString(file.list());
    }

    @Override
    public boolean isCorrect(String[] command) {
        File file = new File(command[0]);
        if(!file.isDirectory())
            return false;
        return true;
    }
}
