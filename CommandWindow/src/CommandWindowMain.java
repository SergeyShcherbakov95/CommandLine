import java.awt.*;

/**
 * Created by Сергей on 14.07.2015.
 */
public class CommandWindowMain {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
                new CommandWindowFrame().makeGUI();
            });
    }
}
