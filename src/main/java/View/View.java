package View;

import Model.*;
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame{

    private JFrame frame;
    private JTextField textFieldFirstPoli;
    private JTextField textFieldSecondPoli;
    private JTextField textFieldDerivInt;
    private JButton button_add = new JButton("+");
    private JButton button_sub = new JButton("-");
    private JButton button_mul = new JButton("*");
    private JButton button_div = new JButton("/");
    private JButton button_int = new JButton("\u0283 ");
    private  JButton button_deriv = new JButton("'");
    private  JTextPane cat = new JTextPane();
    private  JTextPane rest = new JTextPane();
    private  JTextPane derivInt = new JTextPane();
    private JLabel lblIntroduceThePlynomials = new JLabel("Introduce the plynomials to perform operations on:");
    private JLabel lblPolynomialToIntegrate = new JLabel("Introduce one polynomial:");

    private Model model;

    public View(Model model) {
        initialize();
        this.model=model;
    }

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 729, 575);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textFieldFirstPoli = new JTextField();
        textFieldFirstPoli.setBounds(50, 55, 250, 30);
        frame.getContentPane().add(textFieldFirstPoli);
        textFieldFirstPoli.setColumns(10);

        textFieldSecondPoli = new JTextField();
        textFieldSecondPoli.setBounds(372, 55, 270, 30);
        frame.getContentPane().add(textFieldSecondPoli);
        textFieldSecondPoli.setColumns(10);


        button_add.setBounds(134, 113, 87, 30);
        button_add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(button_add);


        button_sub.setBounds(448, 118, 87, 30);
        button_sub.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(button_sub);


        button_mul.setBounds(134, 188, 87, 30);
        button_mul.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(button_mul);


        button_div.setBounds(448, 188, 87, 30);
        button_div.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(button_div);


        button_int.setBounds(448, 396, 87, 30);
        button_int.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(button_int);

        button_deriv.setBounds(145, 396, 87, 30);
        button_deriv.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(button_deriv);


        lblIntroduceThePlynomials.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblIntroduceThePlynomials.setBounds(50, 23, 383, 22);
        frame.getContentPane().add(lblIntroduceThePlynomials);

        JLabel lblCat = new JLabel("Cat:");
        lblCat.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblCat.setBounds(50, 230, 45, 13);
        frame.getContentPane().add(lblCat);

        JLabel lblRest = new JLabel("Rest:");
        lblRest.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblRest.setBounds(388, 230, 45, 13);
        frame.getContentPane().add(lblRest);


        cat.setBounds(50, 265, 263, 32);
        frame.getContentPane().add(cat);

        rest.setBounds(372, 265, 263, 32);
        frame.getContentPane().add(rest);


        derivInt.setBounds(211, 450, 263, 32);
        frame.getContentPane().add(derivInt);




        textFieldDerivInt = new JTextField();
        textFieldDerivInt.setColumns(10);
        textFieldDerivInt.setBounds(211, 332, 263, 30);
        frame.getContentPane().add(textFieldDerivInt);


        lblPolynomialToIntegrate.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblPolynomialToIntegrate.setBounds(10, 333, 191, 22);
        frame.getContentPane().add(lblPolynomialToIntegrate);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Polynomial Calculator");
    }
    public void addAddListener(ActionListener action) {
        button_add.addActionListener(action);
    }
    public void addSubListener(ActionListener action) {
        button_sub.addActionListener(action);
    }
    public void addMulListener(ActionListener action) {
        button_mul.addActionListener(action);
    }
    public void addDivListener(ActionListener action) {
        button_div.addActionListener(action);
    }
    public void addIntListener(ActionListener action) {
        button_int.addActionListener(action);
    }
    public void addDerivListener(ActionListener action) {
        button_deriv.addActionListener(action);
    }

    public String getFirstPoli() {
        return textFieldFirstPoli.getText();
    }

    public String getSecondPoli() {
        return textFieldSecondPoli.getText();
    }

    public String getDerivInt() {
        return textFieldDerivInt.getText();
    }

    public void setCat(String text) {
        this.cat.setText(text);
    }

    public void setRest(String text) {
        this.rest.setText(text);
    }

    public void setDerivInt(String text) {
        this.derivInt.setText(text);
    }
    public void displayErrorMessage(String s){
        this.lblIntroduceThePlynomials.setText(s);
        this.lblIntroduceThePlynomials.setForeground(Color.red);
    }
    public void resetMessage(){
        this.lblIntroduceThePlynomials.setText("Introduce the plynomials to perform operations on:");
        this.lblIntroduceThePlynomials.setForeground(Color.black);
    }
    public void displayErrorMessageLbl(){
        this.lblPolynomialToIntegrate.setText("Introduce one polynomial!");
        this.lblPolynomialToIntegrate.setForeground(Color.red);
    }
    public void resetMessageLbl(){
        this.lblPolynomialToIntegrate.setText("Introduce one polynomial:");
        this.lblPolynomialToIntegrate.setForeground(Color.black);
    }
}
