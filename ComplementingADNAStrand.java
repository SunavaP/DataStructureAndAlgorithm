public class ComplementingADNAStrand {

    public static void main(String[] args) {
        String line = "GTCAG";
        System.out.println(reverseComplemet(line));
        String input = "ACCGGGTTTT";
        System.out.println(reverseComplemet(input));
    }

    private static String reverseComplemet(String dna) {
        StringBuilder stringBuilder = new StringBuilder();
        outer:
        for(int i=dna.length()-1;i>=0;--i) {
            char c = dna.charAt(i);
            switch (c){
                case 'A' : c='T';
                break;
                case 'T':c='A';
                break;
                case 'G':c='C';
                break;
                case 'C':c='G';
                break;
                default:
                    System.out.println("ERROR: Input is not a DNA Sequence.");
                    System.exit(-1);

            }
            stringBuilder = stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }


}
