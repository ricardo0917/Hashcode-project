import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class HashCode implements ActionListener {

    JFrame ventana;
    JLabel neLabel, wordLabel, hashJLabel, groupLabel;
    JTextField neTextField, wordTextField, hashTextField;
    JButton calcularBTN, repButton;
    double valueT = 0;
    double tempHash, temp2 = 0;
    int rango = 0;
    String t;

    public static void main(String[] args) {
        new HashCode();
    }

    HashCode() {
        ventana = new JFrame("Hashtables");
        ventana.setSize(600, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        groupLabel = new JLabel("<html>Ricardo Molinar<html/>");
        groupLabel.setSize(180, 60);
        groupLabel.setLocation(420, 20);
        ventana.add(groupLabel);

        neLabel = new JLabel("Max Hash number: ");
        neLabel.setSize(140, 20);
        neLabel.setLocation(20, 40);
        ventana.add(neLabel);

        // hash range values (mod division)
        neTextField = new JTextField("50000");
        neTextField.setEnabled(false);
        neTextField.setSize(180, 20);
        neTextField.setLocation(160, 40);
        ventana.add(neTextField);

        wordLabel = new JLabel("Word");
        wordLabel.setSize(80, 20);
        wordLabel.setLocation(20, 100);
        ventana.add(wordLabel);

        wordTextField = new JTextField();
        // wordTextField.addKeyListener(this);
        wordTextField.setSize(180, 20);
        wordTextField.setLocation(100, 100);
        ventana.add(wordTextField);

        hashJLabel = new JLabel("Hash");
        hashJLabel.setSize(80, 20);
        hashJLabel.setLocation(20, 160);
        ventana.add(hashJLabel);

        hashTextField = new JTextField();
        hashTextField.setSize(380, 20);
        hashTextField.setLocation(100, 160);
        ventana.add(hashTextField);

        calcularBTN = new JButton("Calculate");
        calcularBTN.setSize(100, 25);
        calcularBTN.setLocation(195, 200);
        calcularBTN.addActionListener(this);
        ventana.add(calcularBTN);

        repButton = new JButton("Try Again");
        repButton.setSize(100, 25);
        repButton.setLocation(305, 200);
        repButton.addActionListener(this);
        repButton.setEnabled(false);
        ventana.add(repButton);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularBTN) {
            calcularBTN.setEnabled(false);
            repButton.setEnabled(true);
            String f = wordTextField.getText();
            String s = f.toLowerCase();
            ArrayList<Integer> digits = new ArrayList<Integer>();

            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                int n = (int) ch - (int) 'a' + 1;
                // this increments values from letter O to Z, that means we can include the
                // spanish letter
                // ñ.
                if (n >= 15)
                    n = n + 1;
                digits.add(n);
            }

            // System.out.println(digits);

            int b = digits.size() - 1;
            double c;
            for (int i = 0; i < digits.size(); i++) {
                // Asking for the letter ñ, because its 145+1
                if (digits.get(i) == 146)
                    // add i to the pos 15 in our index
                    digits.set(i, 15);
                System.out.println(digits);
                System.out.println(digits.get(i));
                c = (Math.pow(28, b)) * (digits.get(i));
                System.out.println(c);
                tempHash = c;
                temp2 += tempHash;
                System.out.println(temp2);

                c = 0;
                b--;
                tempHash = 0;
            }

            t = neTextField.getText();
            rango = Integer.parseInt(t);

            valueT = temp2 % rango;
            hashTextField.setText(String.valueOf(valueT));
        }

        if (e.getSource() == repButton) {
            calcularBTN.setEnabled(true);
            repButton.setEnabled(false);
            wordTextField.setText("");
            hashTextField.setText("");
            temp2 = 0;
        }
    }
}