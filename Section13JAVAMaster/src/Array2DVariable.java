public class Array2DVariable {
    public static void main(String[] args) {

        int [][] numbers= new int [2][];

        numbers[0]= new int[2];
        numbers[1]= new int[3];
        int x=0;
        for(int[]n : numbers){
            for(int i :n){
                i=x*x;
                x++;
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
