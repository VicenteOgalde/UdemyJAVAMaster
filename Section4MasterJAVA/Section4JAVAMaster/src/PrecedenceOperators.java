public class PrecedenceOperators {

    public static void main(String[] args) {

        int i=15;
        int j=8;
        int z= 25;
        double average=(i+j+z)/3d;
        System.out.println("average is : "+average);

        average=i+j+z/3d*10;
        System.out.println("average is : "+average);

        average=i+j+z/(3d*10);
        System.out.println("average is : "+average);

        average=--i + j++ + z/(3d*10);
        System.out.println("average is : "+average);



    }
}
