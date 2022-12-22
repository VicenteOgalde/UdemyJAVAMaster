public class TagWhileAndFor2 {
    public static void main(String[] args) {

        String phrase="tres tristes tigres tragan trigo en un trigal";
        int count=0;
        String text="tri";

        tagLoop1:
        for(int i=0;i<phrase.length();i++){
            int k=i;
            for(int j=0;j<text.length();j++) {
                if (phrase.charAt(k++) != text.charAt(j)) {
                    continue tagLoop1;
                }
            }
            count++;
        }
        System.out.println("find "+count+" the text "+text+" on the phrase "+phrase);

    }
}
