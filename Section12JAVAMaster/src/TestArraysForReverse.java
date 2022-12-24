public class TestArraysForReverse {
    public static void main(String[] args) {

        String [] products= new String [3];
        products[0]="car";
        products[1]="tv";
        products[2]="book";
        int [] numbers= new int [3];
        int length=numbers.length;
        for (int i=0;i<length;i++){
            numbers[i]=i+12;

        }
        for (int i= products.length-1; i>=0 ;i--) {
            System.out.println(products[i]);
        }
        System.out.println("---------------");
        for (int i=0;i<length;i++){

            System.out.println(numbers[length-i-1]);
        }


        





    }
}
