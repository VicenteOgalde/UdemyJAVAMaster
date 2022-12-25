public class TestArraySortFirstAndLast {
    public static void main(String[] args) {

        int [] numbers= new int[10];

        for(int i=0;i<numbers.length;i++){

            numbers[i]=i+1;

        }
        for(int i=0;i<numbers.length/2;i++){
            System.out.print(numbers[i]+" ");
            System.out.println(numbers[numbers.length-1-i]);
        }


    }
}
