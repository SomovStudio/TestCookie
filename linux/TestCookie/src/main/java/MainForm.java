import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class MainForm {
    private JPanel MainPanel;
    private JMenu MenuFile;
    private JMenuItem MenuClose;
    private JTabbedPane tabbedPane1;
    private JMenu MenuAcrion;
    private JMenuItem MenuGetCookie;
    private JMenuBar MenuBar;
    private JPanel Tab1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JTextPane textPane1;

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
                try {
                    CookieManager cookieManager = new CookieManager();
                    CookieHandler.setDefault(cookieManager);

                    URL url = new URL("https://www.google.com/");
                    URLConnection urlConnection = url.openConnection();
                    urlConnection.getContent();

                    CookieStore cookieStore = cookieManager.getCookieStore();
                    String result = "";
                    for (HttpCookie cookie : cookieStore.getCookies()) {
                        result = result + "\n Cookie: " + cookie.getName();
                        result = result + "\t Domain: " + cookie.getDomain();
                        result = result + "\t Value: " + cookie.getValue();
                        //System.out.println("\n Cookie: " + cookie.getName());
                        //System.out.println("\t Domain: " + cookie.getDomain());
                        //System.out.println("\t Value: " + cookie.getValue());
                    }

                    textPane1.setText(result);
                } catch (IOException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });
    }


}
