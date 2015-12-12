import java.io.*;

/**
 * Created by Сергей on 14.07.2015.
 */
public class Command {
    String command;

    Command(String command){
        this.command = command;
    }

    String sendCommand(){
        StringBuilder readerInformation = new StringBuilder();
        Process process = null;
        try {
            String path = new File(".").getCanonicalPath();
            String[] cmd = {"java", "-classpath", path + "/../Core/build/classes", "CoreMain"};
            process = new ProcessBuilder(cmd).start();
            try( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {

                bufferedWriter.write(command);
                bufferedWriter.flush();

                String readLine = null;
                while ((readLine = bufferedReader.readLine()) != null)
                    readerInformation.append(readLine + "\n");
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( process != null)
                process.destroy();
        }
        return readerInformation.toString();
    }
}
