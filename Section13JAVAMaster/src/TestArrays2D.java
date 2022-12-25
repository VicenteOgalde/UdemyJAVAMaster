public class TestArrays2D {
    public static void main(String[] args) {


        int [][] numbers= new int [2][4] ;
        int x=0;
        for (int i []:numbers) {
            for (int j: i ) {
                j=x;
                x++;
            }
        }
        for (int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers[i].length;j++){
                System.out.print(" numbers["+i+"]["+j+"] = "+j);
            }
            System.out.println();

        }
    }
}
