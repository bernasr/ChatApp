import javax.swing.*;
import java.awt.*;

/**
 * Created by JGVSaramago on 24/10/2017.
 */
public class GUI {

    private JFrame frame;
    private JPanel window;
    private JPanel messagePanel;

    public GUI() {
        frame = new JFrame();

        window = new JPanel(new BorderLayout(10,10));
        window.setSize(300,300);
        window.setBackground(new Color(100,100,100));

        createLayout();

        frame.add(window);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(500,500);
        frame.pack();
        frame.setVisible(true);
    }

    private void createLayout() {
        createMessagingPanel();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Aplicação");
        JMenuItem item = new JMenuItem("MenuItem");

        menu1.add(item);
        menuBar.add(menu1);
        window.add(menuBar, BorderLayout.NORTH);
    }

    private void createMessagingPanel() {
        JScrollPane panel = new JScrollPane();
        messagePanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JTextArea text1 = new JTextArea("Olá, tudo bem?");
        text1.setEditable(false);
        text1.setMargin(new Insets(7,7,7,7));
        constraints.gridx = 0;
        constraints.gridy = 0;
        messagePanel.add(text1, constraints);

        JTextArea text2 = new JTextArea("Olá, tudo bem?");
        text2.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        messagePanel.add(text2, constraints);

        panel.add(messagePanel);
        window.add(messagePanel, BorderLayout.CENTER);
    }

    public void addNewMessage(String message, String username, boolean isReceiving){

    }
}
