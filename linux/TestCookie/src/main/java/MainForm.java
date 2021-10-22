import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JPanel MainPanel;
    private JMenu MenuFile;
    private JMenuItem MenuClose;
    private JTabbedPane tabbedPane1;
    private JMenu MenuAcrion;
    private JMenuItem MenuGetCookie;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TestCookie");
        frame.pack();
        frame.setVisible(true);
    }

    public MainForm() {
        MenuClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        MenuGetCookie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
