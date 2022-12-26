public class TestArrays2DString {
    public static void main(String[] args) {


        String [][] names= new String [2][4] ;
        
        int x=0;
        for (int i=0;i<names.length;i++){
            for(int j=0;j<names[i].length;j++){
                names[i][j]="user"+x;
                x++;
            }

        }
        for (int i=0;i<names.length;i++){
            for(int j=0;j<names[i].length;j++){
                System.out.print(" names["+i+"]["+j+"] = "+names[i][j]);
            }
            System.out.println();

        }
    }
}
