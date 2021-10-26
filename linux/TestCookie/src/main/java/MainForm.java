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
    private JList listLinks;
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JTextField textFieldLink;
    private JTextPane textPane1;
    private JButton buttonGetCookie;
    private JMenu MenuHelp;
    private JMenuItem MenuAbout;

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
                String result = "";
                TestCookie testCookie = new TestCookie();
                for(int i = 0; i < listLinks.getModel().getSize(); i++) {
                    result = result + testCookie.getCookie(listLinks.getModel().getElementAt(i).toString());

                }
                textPane1.setText(result);
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listLinks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                DefaultListModel listModel = new DefaultListModel();
                for(int i = 0; i < listLinks.getModel().getSize(); i++) {
                    listModel.addElement(listLinks.getModel().getElementAt(i).toString());
                }
                listModel.addElement(textFieldLink.getText());
                listLinks.setModel(listModel);
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listLinks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                int index = listLinks.getSelectedIndex();
                DefaultListModel listModel = new DefaultListModel();
                for(int i = 0; i < listLinks.getModel().getSize(); i++) {
                    if(index == i)continue;
                    listModel.addElement(listLinks.getModel().getElementAt(i).toString());
                }
                listLinks.setModel(listModel);
            }
        });
        buttonGetCookie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = "";
                TestCookie testCookie = new TestCookie();
                for(int i = 0; i < listLinks.getModel().getSize(); i++) {
                    result = result + testCookie.getCookie(listLinks.getModel().getElementAt(i).toString());

                }
                textPane1.setText(result);
            }
        });
        MenuAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String context = "Программа: TestCookie";
                context += System.getProperty("line.separator") + "----------------------------------------------------------------------";
                context += System.getProperty("line.separator") + "Разработчик: Сомов Евгений Павлович";
                context += System.getProperty("line.separator") + "Сайт: https://somovstudio.github.io";
                context += System.getProperty("line.separator") + "Почта: somov.studio@gmail.com";
                context += System.getProperty("line.separator") + "Дата последнего обновления: 26.10.2021";
                context += System.getProperty("line.separator") + "Версия: 1.0";
                context += System.getProperty("line.separator") + "Лицензия: GNU";
                context += System.getProperty("line.separator") + "----------------------------------------------------------------------";
                context += System.getProperty("line.separator") + "© Somov Evgeniy, 2021. All Rights Reserved.";
                JOptionPane.showMessageDialog(null, context);
            }
        });
    }


}
