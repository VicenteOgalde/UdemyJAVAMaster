package cl.vicoga.exceptions.test;

import javax.swing.*;

public class TestExceptions {
    public static void main(String[] args) {
        String x= JOptionPane.showInputDialog("type a number");
        int divide1;
        try {

            divide1 =  Integer.parseInt(x);
            int sum = 5/divide1;
            int divide = 10 / 0;

        }catch (NumberFormatException nfe){
            System.out.println(nfe.getMessage());

        }catch (ArithmeticException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }finally {
            System.out.println("always execute");
        }
    }
}
