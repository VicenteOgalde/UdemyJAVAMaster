package cl.vicoga.exceptions.test;

import javax.swing.*;

public class TestExceptions {
    public static void main(String[] args) {
        String x= JOptionPane.showInputDialog("type a number");
        int divide1;
        try {

            divide1 =  Integer.parseInt(x);
            Calculator.divide(10,divide1);





        }catch (ArithmeticException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        } catch (DivideZeroException dze) {
            dze.printStackTrace();
        } finally {
            System.out.println("always execute");
        }
    }
}
