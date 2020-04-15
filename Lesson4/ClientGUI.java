package ru.geekbrains.java2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler, KeyListener {


private static final int WIDTH = 400;
private static final int HEIGHT = 300;

        PrintStream writer=new PrintStream("log.txt");
private final JTextArea log = new JTextArea();
private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
private final JTextField tfIPAddress = new JTextField("127.0.0.1");
private final JTextField tfPort = new JTextField("8189");
private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top", true);
private final JTextField tfLogin = new JTextField("ivan");
private final JPasswordField tfPassword = new JPasswordField("123");
private final JButton btnLogin = new JButton("Login");

private final JPanel panelBottom = new JPanel(new BorderLayout());
private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
private final JTextField tfMessage = new JTextField();
private final JButton btnSend = new JButton("Send");


private final JList<String> userList = new JList<>();


        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
@Override
public void run() {
        try {
                new ClientGUI();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
}
        });
        }

        ClientGUI() throws FileNotFoundException {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setAlwaysOnTop(true);
        userList.setListData(new String[]{"user1", "user2", "user3", "user4",
        "user5", "user6", "user7", "user8", "user9",
        "user-with-exceptionally-long-name-in-this-chat"});
        JScrollPane scrUser = new JScrollPane(userList);
        JScrollPane scrLog = new JScrollPane(log);
        scrUser.setPreferredSize(new Dimension(100, 0));
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        log.setEditable(false);
        cbAlwaysOnTop.addActionListener(this);
        btnSend.addActionListener(this::actionPerformed);
        tfMessage.addKeyListener(this);


        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(scrUser, BorderLayout.EAST);
        add(scrLog, BorderLayout.CENTER);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
        }
        private void logFile() throws FileNotFoundException {
        String text=tfMessage.getText();
        writer.append(text +"\n");      //по идее надо проверить на существование файл и либо дописывать либо создать потом дописывать. Но как не лазил не получилось это сделать
                                         //ничего умнее чем закрывать тут не придумал.
                                        // Хотя правильнее наверное было бы по нажатию закрытия окна. Но как так и не нашел
                                        //и еще вопрос на сколько правильно записывать в лог файл каждое сообщение - процесс медленный же

}


@Override
public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
        setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if (src==btnSend){
                String text = tfMessage.getText();
                try{
                logFile();
                } catch(IOException a) {
                a.printStackTrace();}
                log.append(text + "\n");
                tfMessage.setText("");

        } else {
        throw new RuntimeException("Unknown source:" + src);
        }
        }


@Override
public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = String.format("Exception in \"%s\" %s: %s\n\tat %s",
        t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                String text = tfMessage.getText();
                                try{
                                        logFile();
                                } catch(IOException a) {
                                a.printStackTrace();}
                                log.append(text + "\n");
                                tfMessage.setText("");

                        }
                        }
        }

