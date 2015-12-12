import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Сергей on 14.07.2015.
 */
public class CommandWindowFrame {
    private JFrame window;
    private JPanel centerPanel;
    private JTextArea informationArea;
    private JTextField commandField;
    private JButton sendButton;

    CommandWindowFrame(){
        window = new JFrame("Command Window");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 300);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void makeGUI(){
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        window.add(centerPanel, BorderLayout.CENTER);

        informationArea = new JTextArea(10, 40);
        informationArea.setLineWrap(true);
        informationArea.setWrapStyleWord(true);
        JScrollPane jScrollPane = new JScrollPane(informationArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        commandField = new JTextField(41);
        sendButton =  new JButton("Send");

        centerPanel.add(jScrollPane);
        centerPanel.add(commandField);
        centerPanel.add(sendButton);

        sendButton.addMouseListener(new sendMouseListener());
        commandField.addKeyListener(new sendKeyListener());
    }

    private void sendCommand(){
        String readerInformation = new Command(commandField.getText() + "\n").sendCommand();
        informationArea.append(">");
        informationArea.append(commandField.getText() + "\n");
        informationArea.append(readerInformation + "\n");
        commandField.setText("");
    }

    class sendMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            sendCommand();
        }

        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    class sendKeyListener implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                sendCommand();
            }
        }

        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
}
