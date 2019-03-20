import java.io.*;

public class compute_a_posteriori {
    public static void main(String args[]) {

        int cherrycount = 0, limecount = 0;
        double[] h = {0.1, 0.2, 0.4, 0.2, 0.1};
        double[] cherryP = {1, 0.75, 0.5, 0.25, 0};
        double[] limesP = {0, 0.25, 0.5, 0.75, 1};
        if (args.length > 1) {
            FileWriterFunc(" number of arguments is > 1");
            System.exit(0);
        }

        String inputArgument = "";
        if (args.length == 0) {
            FileWriterFunc("Observation sequence Q: :");
            FileWriterFunc("Length of Q: " + 0 + "\n");
            FileWriterFunc("\nProbability that the next candy we pick will be C, given Q:0.5");
            FileWriterFunc("Probability that the next candy we pick will be L, given Q:0.5");

        } else {
            inputArgument = args[0].toString().toUpperCase();
            FileWriterFunc("Observation sequence Q: " + inputArgument +":");
            FileWriterFunc("Length of Q: " + inputArgument.length() + "\n");
        }
        int length = inputArgument.length();
        char stringSplitArray[] = inputArgument.toCharArray();
        double[][] hAlpha = new double[length][5];
        double sum = 0.0;
        for (int i = 0; i < length; i++) {
            if (stringSplitArray[i] == 'C') cherrycount++;
            else if (stringSplitArray[i] == 'L') limecount++;

            FileWriterFunc("After Observation " + (i+1) + " = " + stringSplitArray[i] + "\n\n");
            double alpha = 0.00;

            for (int j = 0; j < 5; ++j) {
                hAlpha[i][j] = Math.pow(cherryP[j], cherrycount) * Math.pow(limesP[j], limecount) * h[j];
                sum = sum + hAlpha[i][j];
            }

            alpha = 1 / sum;
            sum = 0.0;
            double posteriorProb = 0.0;
            for (int j = 0; j < 5; ++j) {
                hAlpha[i][j] = alpha * hAlpha[i][j];
                FileWriterFunc("P(h" + (j + 1) + " | Q) =" + String.format("%.10f", hAlpha[i][j]));
//                FileWriterFunc("P(h1 | Q) =" + String.format("%.5f", hAlpha[i][j]));
                if (stringSplitArray[i] == 'C')
                    posteriorProb = posteriorProb + hAlpha[i][j] * cherryP[j];
                else if (stringSplitArray[i] == 'L')
                    posteriorProb = posteriorProb + hAlpha[i][j] * limesP[j];

            }
            if (stringSplitArray[i] == 'C') {
                FileWriterFunc("\nProbability that the next candy we pick will be C, given Q:" + String.format("%.10f", posteriorProb));
                FileWriterFunc("Probability that the next candy we pick will be L, given Q:" + String.format("%.10f", 1-posteriorProb)+"\n");
            } else if (stringSplitArray[i] == 'L') {
                FileWriterFunc("\nProbability that the next candy we pick will be C, given Q:" + String.format("%.10f", 1-posteriorProb));
                FileWriterFunc("Probability that the next candy we pick will be L, given Q:" + String.format("%.10f", posteriorProb)+"\n");
            }
        }

    }

    public static void FileWriterFunc(String text) {
        try {
            FileWriter writer = new FileWriter("result.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
