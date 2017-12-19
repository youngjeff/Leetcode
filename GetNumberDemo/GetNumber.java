package GetNumberDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetNumber extends Frame {
    private TextField textField;
    private TextField statusLabel;

    public GetNumber() {
        Panel p = new Panel();
        p.add(new Label("Number:"));
        p.add(textField = new TextField(10));
        add(BorderLayout.NORTH, p);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textField.getText();
                statusLabel.setText(process(s).toString());
            }
        });
        add(BorderLayout.SOUTH, statusLabel = new TextField(10));
        pack();
    }

    private static Number NAN = new Double(Double.NaN);

    public static Number process(String s) {
        if (s.matches("[+-]*\\d*\\.\\d+[dDeEfF]*")) {
            try {
                double dValue = Double.parseDouble(s);
                System.out.println("It's a double:" + dValue);
                return Double.valueOf(dValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid double: " + s);
                return NAN;
            }

        }else{
            try{
                int iValue = Integer.parseInt(s);
                System.out.println("It's an int:" + iValue);
                return NAN;
            }catch (NumberFormatException e2){
                System.out.println("Not a number: " + s);
                return NAN;
            }
        }

    }
    public static void main(String[] ap){
        new GetNumber().setVisible(true);
    }
}