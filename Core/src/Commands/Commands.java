package Commands;

/**
 * Created by Сергей on 14.07.2015.
 */
public abstract class Commands {
    public static Commands getCommand(String command){
        command = command.toUpperCase();
        if(command.equals("DIR"))
            return new CommandDIR();
        if(command.equals("DATE"))
            return new CommandDATE();
        if(command.equals("HELP"))
            return new CommandHELP();
        return null;
    }

    public abstract String doCommand(String[] command);
    public abstract boolean isCorrect(String[] command);
}
