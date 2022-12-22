public class TagWhileAndFor {
    public static void main(String[] args) {


        loop1:
        for (int i=0;i<5;i++){
            System.out.println();
            for(int j=0;j<5;j++) {
                if (i == 2) {
                    continue loop1;
                }
                System.out.print("loop1 iteration n°"+i+" loop2 iteration n°"+j);
            }

        }
        System.out.println("\n==============================");

        loop2:
        for (int i=0;i<5;i++){
            System.out.println();
            for(int j=0;j<5;j++) {
                if (i == 2) {
                    break loop2;
                }
                System.out.print("loop1 iteration n°"+i+" loop2 iteration n°"+j);
            }

        }

    }
}
