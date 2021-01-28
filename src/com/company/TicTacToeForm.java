package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TicTacToeForm extends JFrame {

    JPanel mainPanel;
    JPanel gamePanel;
    JButton btn_0_0;
    JButton btn_0_1;
    JButton btn_0_2;
    JButton btn_1_0;
    JButton btn_1_1;
    JButton btn_1_2;
    JButton btn_2_0;
    JButton btn_2_1;
    JButton btn_2_2;
    JMenuBar menuBar;

    private TicTacToe game = new TicTacToe();

    public TicTacToeForm() {
        super("Tic Tac Toe");
        setSize(300, 320);
        setResizable(false); // запрещает изменять размеры поля
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void open(){
        initUI();
        setVisible(true); // запускает форму
    }
    private void initUI(){
     mainPanel = new JPanel();
     mainPanel.setLayout(new BorderLayout()); // делит поле на части


     gamePanel = new JPanel();
     gamePanel.setLayout(new GridLayout(3,3)); // делит поле на равные квадраты

     menuBar = new JMenuBar();
     JMenu gameMenu = new JMenu("Game");
     JMenuItem restartItem = new JMenuItem("Restart");
     restartItem.addActionListener(e -> {
     game.restart();
     handleButtonState(true);
     clearButtonsText();
     });

     gameMenu.add(restartItem);
     menuBar.add(gameMenu);
     mainPanel.add(BorderLayout.NORTH, menuBar);

     // mainPanel.setBackground(Color.CYAN); // устанавливает цвет панели
     btn_0_0 = new JButton();
     btn_0_1 = new JButton();
     btn_0_2 = new JButton();
     btn_1_0 = new JButton();
     btn_1_1 = new JButton();
     btn_1_2 = new JButton();
     btn_2_0 = new JButton();
     btn_2_1 = new JButton();
     btn_2_2 = new JButton();

     for (JButton jButton : Arrays.asList(btn_0_0, btn_0_1, btn_0_2, btn_1_0, btn_1_1, btn_1_2, btn_2_0, btn_2_1, btn_2_2)) {
            gamePanel.add(jButton);
        }

     btn_0_0.addActionListener(e -> handleButtonClick(0,0,btn_0_0));

     btn_0_1.addActionListener(e -> handleButtonClick(0,1,btn_0_1));

     btn_0_2.addActionListener(e -> handleButtonClick(0,2,btn_0_2));

     btn_1_0.addActionListener(e -> handleButtonClick(1,0,btn_1_0));

     btn_1_1.addActionListener(e -> handleButtonClick(1,1,btn_1_1));

     btn_1_2.addActionListener(e -> handleButtonClick(1,2,btn_1_2));

     btn_2_0.addActionListener(e -> handleButtonClick(2,0,btn_2_0));

     btn_2_1.addActionListener(e -> handleButtonClick(2,1,btn_2_1));

     btn_2_2.addActionListener(e -> handleButtonClick(2,2,btn_2_2));

     mainPanel.add(BorderLayout.CENTER, gamePanel);

     setContentPane(mainPanel);
    }

    private void clearButtonsText() {
        for (JButton jButton : Arrays.asList(btn_0_0, btn_0_1, btn_0_2, btn_1_0, btn_1_1, btn_1_2, btn_2_0, btn_2_1, btn_2_2)) {
            jButton.setText("");
        }
    }

    private void handleButtonClick(int row, int column, JButton btn) {
        var result = game.placeMark(row,column);
        var symbol = game.getValue(row,column);
        btn.setText(String.valueOf(symbol));
        switch (result) {

            case DEUCE -> {
                //btn_0_0.setBackground(Color.MAGENTA); - красит конкретную кнопку в выбранный цвет
                handleButtonState(false);
                JOptionPane.showMessageDialog(null,"It's deuce");
            }
            case X_WON -> {
                handleButtonState(false);
                JOptionPane.showMessageDialog(null,"X won");

            }
            case O_WON -> {
                handleButtonState(false);
                JOptionPane.showMessageDialog(null,"O won");
            }
        }
    }
    private void handleButtonState(boolean enabled){
        for (JButton jButton : Arrays.asList(btn_0_0, btn_0_1, btn_0_2, btn_1_0, btn_1_1, btn_1_2, btn_2_0, btn_2_1, btn_2_2)) {
            jButton.setEnabled(enabled);
        }
    }
}
