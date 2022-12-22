public class OperatorInstanceOfGenericTypes {
    public static void main(String[] args){

        Object text= "hello instance";
        Number num = 123;
        boolean b1=  text instanceof Integer;
        System.out.println("b1 = "+b1);
        b1=  text instanceof Object;
        System.out.println("b1 = "+b1);
        b1=  num instanceof Integer;
        System.out.println("b1 = "+b1);
        b1=  num instanceof Number;
        System.out.println("b1 = "+b1);
        b1=  num instanceof Long;
        System.out.println("b1 = "+b1);
    }
}
