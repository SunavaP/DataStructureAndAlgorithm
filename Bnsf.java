import sun.nio.cs.StandardCharsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bnsf {

    public static void main(String[] args) {
//        String line = "GCGAG 2 CCACGGCCTATGTATTTGCAAGGATCTGGGCCAGCTAAATCAGCACCCCTGGAACGGCAAGGTTCATTTTGTTGCGCGCATAG";
        String line = "CCC 1 CGCCCGAATCCAG";
        List<String> ss = new ArrayList<String>();
        String[] dna = line.split("\\ ");
        String part = dna[0];
        int length = dna[2].length();
        int trimSize = dna[0].length();
        int flag = Integer.parseInt(dna[1]);
        for(int i=0;i<=(length-trimSize);++i) {
            String cut = dna[2].substring(i,i+trimSize);
            int count = 0;
            for(int j=0;j<cut.length();++j){
                if(cut.charAt(j) != part.charAt(j))
                    count++;
            }
            if(count <= flag)
                ss.add(cut);
        }
        Collections.sort(ss);
        System.out.print(ss.toString());
    }
}

//GCAAG GCAAG GCCAG GCGCG GCGCA GCTAA
//GCAAG GCCAG GCTAA GCAAG GCGCG GCGCA