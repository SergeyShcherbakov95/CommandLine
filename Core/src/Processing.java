import Commands.*;
import java.io.*;

/**
 * Created by Сергей on 14.07.2015.
 */
public class Processing implements Runnable {

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String[] commandArray = bufferedReader.readLine().trim().split("[ ]+");
            Commands command = Commands.getCommand(commandArray[0]);
            String result;
            if(command == null)
                result =  "Command is incorrect. Send 'help' for see all commands";
            else
                result = command.doCommand(commandArray);
            System.out.println(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
