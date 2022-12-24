public class TestArraysForReverseMutable {
    public static void main(String[] args) {

        String [] products= new String [4];
        products[0]="car";
        products[1]="tv";
        products[2]="book";
        products[3]="bb";
        int length=products.length;
        for (int i=0; i<(length/2) ;i++) {
            String a=products[i];
            String b=products[length-1-i];
            products[length-1-i]=a;
            products[i]=b;
        }


        for (String p:products) {
            System.out.println("p = " + p);
        }

        





    }
}
