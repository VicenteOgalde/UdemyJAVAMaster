public class Array2DFindEl {
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

        System.out.println();

        int elFind=4;
        boolean find=false;

        find:for(int[] i:numbers){
            for(int j:i){
                if(j==elFind){
                    find=true;
                    break find;
                }
            }
        }


    }
}
