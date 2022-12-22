public class OperatorInstanceOf {
    public static void main(String[] args){

        String text= "hello instance";
        Integer num = 123;
        boolean b1=  text instanceof String;
        System.out.println("b1 = "+b1);
        b1=  text instanceof Object;
        System.out.println("b1 = "+b1);
        b1=  num instanceof Integer;
        System.out.println("b1 = "+b1);
        b1=  num instanceof Number;
        System.out.println("b1 = "+b1);
    }
}
