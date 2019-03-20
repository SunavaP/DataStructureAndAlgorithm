import java.io.*;

public class Posterior {

    public static void main(String args[]) {

// code for command line args -- for now hard coding command line args
        // to check the number of arguments <2
        if (args.length > 1) {
            WriteToFile(" number of arguments should be 1");
            System.exit(0);
        }

        String input;
        if (args.length == 0) {
            input = "";
        } else {
            input = args[0].toString().toUpperCase();
        }
        int length = input.length();
        WriteToFile("Observation sequence Q:" + " " + input);
        WriteToFile("Observation sequence Q:" + " " + input);
        WriteToFile("Length of Q:" + " " + length);
        WriteToFile("Length of Q:" + " " + length);
        // code for finding number of cherries and limes
        char bag[] = input.toCharArray();
        int cherrycount = 0, limecount = 0;
        for (int i = 0; i < length; i++) {
            if (bag[i] == 'C') cherrycount++;
            else if (bag[i] == 'L') limecount++;

            //checking the number of cherries and limes
            WriteToFile("********************************");
            WriteToFile("********************************");
            WriteToFile("cherries--" + cherrycount + "\n limes--" + limecount);
            WriteToFile("cherries--" + cherrycount + "\n limes--" + limecount);
            WriteToFile("********************************");
            WriteToFile("********************************");
            // code start for finding alpha
            double alpha = 0.00;
            //P(h1|q)
            double h1 = 0.1, c1 = 1.0, l1 = 0.0;
            //P(h1|cherries and limes)
            //formula P(hk|X) = alpha*P(X|hk)P(hk)
            Double H1alpha = Math.pow(c1, cherrycount) * Math.pow(l1, limecount) * h1;
            //FileWriterFunc(H1alpha);

            //P(h2|q)
            double h2 = 0.2, c2 = 0.75, l2 = 0.25;
            Double H2alpha = Math.pow(c2, cherrycount) * Math.pow(l2, limecount) * h2;
            //FileWriterFunc(H2alpha);

            //P(h3|q)
            double h3 = 0.4, c3 = 0.5, l3 = 0.5;
            Double H3alpha = Math.pow(c3, cherrycount) * Math.pow(l3, limecount) * h3;
            //FileWriterFunc(H3alpha);

            //P(h4|q)
            double h4 = 0.2, c4 = 0.25, l4 = 0.75;
            Double H4alpha = Math.pow(c4, cherrycount) * Math.pow(l4, limecount) * h4;
            //FileWriterFunc(H4alpha);

            //P(h5|q)
            double h5 = 0.1, c5 = 0.0, l5 = 1.0;
            Double H5alpha = Math.pow(c5, cherrycount) * Math.pow(l5, limecount) * h5;
            //FileWriterFunc(H5alpha);

            alpha = computeAlpha(H1alpha, H2alpha, H3alpha, H4alpha, H5alpha);
            //FileWriterFunc(alpha);
            //multiplying with alpha
            H1alpha = alpha * H1alpha;
            H2alpha = alpha * H2alpha;
            H3alpha = alpha * H3alpha;
            H4alpha = alpha * H4alpha;
            H5alpha = alpha * H5alpha;
            output(H1alpha, H2alpha, H3alpha, H4alpha, H5alpha, c1, c2, c3, c4, c5, l1, l2, l3, l4, l5);

            // to file
        }

    }

    private static void output(Double h1alpha, Double h2alpha, Double h3alpha,
                               Double h4alpha, Double h5alpha, double h1, double h2, double h3, double h4, double h5, double l1, double l2, double l3, double l4, double l5) {
        // formatting to 5 delcimal places
        WriteToFile("P(h1 | Q) =" + String.format("%.5f", h1alpha));
        WriteToFile("P(h2 | Q) =" + String.format("%.5f", h2alpha));
        WriteToFile("P(h3 | Q) =" + String.format("%.5f", h3alpha));
        WriteToFile("P(h4 | Q) =" + String.format("%.5f", h4alpha));
        WriteToFile("P(h5 | Q) =" + String.format("%.5f", h5alpha));
        WriteToFile("*******************************");
        double cherry = (h1 * h1alpha + h2 * h2alpha + h3 * h3alpha + h4 * h1alpha + h5 * h1alpha);
        WriteToFile("Probability that the next candy we pick will be C, given Q:" + String.format("%.5f", cherry));
        double lime = (l1 * h1alpha + l2 * h2alpha + l3 * h3alpha + l4 * h1alpha + l5 * h1alpha);
        WriteToFile("Probability that the next candy we pick will be L, given Q:" + String.format("%.5f", lime));
        //to file
        WriteToFile("P(h1 | Q) =" + String.format("%.5f", h1alpha));
        WriteToFile("P(h2 | Q) =" + String.format("%.5f", h2alpha));
        WriteToFile("P(h3 | Q) =" + String.format("%.5f", h3alpha));
        WriteToFile("P(h4 | Q) =" + String.format("%.5f", h4alpha));
        WriteToFile("P(h5 | Q) =" + String.format("%.5f", h5alpha));
        WriteToFile("*******************************");
        WriteToFile("Probability that the next candy we pick will be C, given Q:" + String.format("%.5f", cherry));
        WriteToFile("Probability that the next candy we pick will be L, given Q:" + String.format("%.5f", lime));
    }

    public static double computeAlpha(Double h1alpha, Double h2alpha,
                                      Double h3alpha, Double h4alpha, Double h5alpha) {
        // computing alpha
        double Alphatemp = 1 / (h1alpha + h2alpha + h3alpha + h4alpha + h5alpha);
        //FileWriterFunc(Alphatemp);
        return Alphatemp;
    }

    public static void WriteToFile(String text) {
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
