package com.AWT;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    TextField textField = new TextField(10);

    public Main() { // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args) {
        Main myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showActionListenerDemo(); // и вызываемый метод showDialogDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI() {
        mainFrame = new Frame("Java AWT Dialog");  // инициализация фрэйма
        mainFrame.setSize(400, 500); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener(new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent) { // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350, 100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в showActionListenerDemo
    private void showActionListenerDemo() {
        headerLabel.setText("Listener in action: ActionListener");

        //----------------------------------------------------- 1
        ScrollPane panel1 = new ScrollPane();
        panel1.setBackground(Color.magenta);

        Button okButton0 = new Button("OK");

        okButton0.addActionListener(new CustomActionListener());
        panel1.add(okButton0);
        controlPanel.add(panel1);

        //----------------------------------------------------- 2
        ScrollPane panel = new ScrollPane();
        panel.setBackground(Color.GREEN);

        Label msglabel = new Label();
        msglabel.setAlignment(Label.CENTER);
        msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");
        panel.add(msglabel);

        msglabel.addComponentListener(new CustomComponentListener());
        controlPanel.add(panel);

        //----------------------------------------------------- 3
        headerLabel.setText("Listener in action: ItemListener");
        Checkbox chkApple = new Checkbox("Apple");
        Checkbox chkMango = new Checkbox("Mango");
        Checkbox chkPeer = new Checkbox("Peer");

        chkApple.addItemListener(new CustomItemListener());
        chkMango.addItemListener(new CustomItemListener());
        chkPeer.addItemListener(new CustomItemListener());

        controlPanel.add(chkApple);
        controlPanel.add(chkMango);
        controlPanel.add(chkPeer);

        //----------------------------------------------------- 4
        textField.addKeyListener(new CustomKeyListener());
        Button okButton2 = new Button("OK");
        okButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Entered text: " + textField.getText());
            }
        });

        controlPanel.add(textField);
        controlPanel.add(okButton2);

        //----------------------------------------------------- 5
        Panel panel3 = new Panel();
        panel3.setBackground(Color.LIGHT_GRAY);
        panel3.setLayout(new FlowLayout());
        panel3.addMouseListener(new CustomMouseListener());

        Label msglabel2 = new Label();
        msglabel2.setAlignment(Label.CENTER);
        msglabel2.setText("Welcome to TutorialsPoint AWT Tutorial.");

        msglabel2.addMouseListener(new CustomMouseListener());
        panel3.add(msglabel2);

        controlPanel.add(panel3);

        

        mainFrame.setVisible(true);
    }
    //-------------------------------------------------------------------------------------

    //----------------------------------------------------- 1
    class CustomActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Ok Button Clicked.");
        }
    }

    //----------------------------------------------------- 2
    class CustomComponentListener implements ComponentListener {

        public void componentResized(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText()
                    + e.getComponent().getClass().getSimpleName() + " resized. ");
        }

        public void componentMoved(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText()
                    + e.getComponent().getClass().getSimpleName() + " moved. ");
        }

        public void componentShown(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText()
                    + e.getComponent().getClass().getSimpleName() + " shown. ");
        }

        public void componentHidden(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText()
                    + e.getComponent().getClass().getSimpleName() + " hidden. ");
        }
    }

    //----------------------------------------------------- 3
    class CustomItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            statusLabel.setText(e.getItem()
                    +" Checkbox: "
                    + (e.getStateChange()==1?"checked":"unchecked"));
        }
    }

    //----------------------------------------------------- 4
    class CustomKeyListener implements KeyListener{
        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                statusLabel.setText("Entered text: " + textField.getText());
            }
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    //----------------------------------------------------- 5
    class CustomMouseListener implements MouseListener{

        public void mouseClicked(MouseEvent e) {
            statusLabel.setText("Mouse Clicked: ("
                    +e.getX()+", "+e.getY() +")");
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }
}