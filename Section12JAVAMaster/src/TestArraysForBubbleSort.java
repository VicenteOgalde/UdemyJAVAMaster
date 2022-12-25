public class TestArraysForBubbleSort {
    public static void main(String[] args) {

        String [] products= new String [4];
        products[0]="car";
        products[1]="tv";
        products[2]="book";
        products[3]="bb";
        int length=products.length;
        int count=0;
        for (int i=0; i<length-1 ;i++) {
            for (int j=0;j<length-1-i;j++){
                if(products[j+1].compareTo(products[j])<0){
                    String aux=products[j];
                    products[j]=products[j+1];
                    products[j+1]=aux;
                }
                count++;
            }

        }

        System.out.println(count);
        for (String p:products) {
            System.out.println("p = " + p);
        }

        





    }

}
