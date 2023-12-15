package NumberGuessing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Game extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JButton Go;
    private int x;
    private JLabel hint;
    private int attemptsLeft;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Game frame = new Game();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Game() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 938, 510);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome to Number Guessing Game");
        lblNewLabel.setBounds(74, 27, 685, 46);
        lblNewLabel.setForeground(new Color(255, 0, 51));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter the Guessed number");
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(328, 94, 201, 25);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(334, 130, 103, 31);
        contentPane.add(textField);
        textField.setColumns(10);

        hint = new JLabel("Hint");
        hint.setForeground(new Color(255, 0, 0));
        hint.setFont(new Font("Tahoma", Font.PLAIN, 18));
        hint.setHorizontalAlignment(SwingConstants.CENTER);
        hint.setBounds(162, 172, 541, 115);
        contentPane.add(hint);

        Go = new JButton("Go");
        Go.setBounds(438, 130, 53, 31);
        contentPane.add(Go);
        Go.addActionListener(this);

        startNewGame();
    }

    public void startNewGame() {
    	 Random ran = new Random();
        x = ran.nextInt(10);
        attemptsLeft = 5;
        textField.setText("");
        hint.setText("Guess a number between 0 and 9");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Go) {
            String inputText = textField.getText();
            try {
                int input = Integer.parseInt(inputText);

                if (input == x) {
                    JOptionPane.showMessageDialog(this,
                            "Wooohoo! You guessed it!\nAttempts used: " + (5 - attemptsLeft),
                            "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    startNewGame();
                } else {
                    textField.setText("");
                    if(input<x)
                    hint.setText("Number is greater than your guess! Try again!!");
                    else
                    	hint.setText("Number is smaller than your guess! Try again!!");
                    attemptsLeft--;

                    if (attemptsLeft == 0) {
                        JOptionPane.showMessageDialog(this, "Game Over! The correct number was " + x,
                                "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        startNewGame();
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
