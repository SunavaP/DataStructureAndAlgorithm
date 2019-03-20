import java.util.*;

public class bnet {
    static Map<String, Double> bT = new HashMap<String, Double>();
    static Map<String, Double> eT = new HashMap<String, Double>();
    static Map<String, Double> aT = new HashMap<String, Double>();
    static Map<String, Double> jCT = new HashMap<String, Double>();
    static Map<String, Double> mCT = new HashMap<String, Double>();
    static Map<Character, ArrayList<Character>> conditions, givenValues;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (args.length < 1 || args.length > 6) {
            System.out.println("Wrong number of arguments.Should be between 1-6.\n");
            System.exit(0);
        }
        bT.put("B_T", 0.001);
        eT.put("E_T", .002);
        /**TT values of Alarm*/
        aT.put("A_T|B_T,E_T", 0.95);
        aT.put("A_T|B_T,E_F", 0.94);
        aT.put("A_T|B_F,E_T", 0.29);
        aT.put("A_T|B_F,E_F", 0.001);
        /**TT values of JohnCalls*/
        jCT.put("J_T|A_T", 0.90);
        jCT.put("J_T|A_F", 0.05);
        /**TT values of MaryCall*/
        mCT.put("M_T|A_T", 0.70);
        mCT.put("M_T|A_F", 0.01);
        int counter = 0;

        givenValues = new HashMap<Character, ArrayList<Character>>();
        conditions = new HashMap<Character, ArrayList<Character>>();
        for (String inline : args) {
            ArrayList<Character> possibleBool = new ArrayList<Character>();
            if (inline.equals("given")) {
                counter = 1;
                continue;
            }
            if (counter == 0) {
                String temp = inline.toUpperCase();
                possibleBool.add(temp.charAt(1));
                conditions.put(temp.charAt(0), possibleBool);
            } else {
                String temp = inline.toUpperCase();
                possibleBool.add(temp.charAt(1));
                givenValues.put(temp.charAt(0), possibleBool);
            }
        }
        if (conditions.keySet().size() < 1 || conditions.keySet().size() > 5) {
            System.out.println("The number of conditions should be between 1 - 5.\n!!!Exiting the Program!!!!");
            System.exit(0);
        } else if (givenValues.keySet().size() < 1 || givenValues.keySet().size() > 4) {
            System.out.println("The number of given statements should be between 1 - 4.\n!!!Exiting the Program!!!!");
            System.exit(0);
        }
        conditions.putAll(givenValues);
        conditions.putAll(generateRemainingPossibleValues(conditions));
        givenValues.putAll(generateRemainingPossibleValues(givenValues));
        double numerator = computeConditionalProbability(conditions);
        double denominator = counter != 1?1:computeConditionalProbability(givenValues);

        System.out.print("Probability of the statement ' ");
        for (int s = 0; s < args.length; s++) {
            System.out.print(args[s] + " ");
        }
        System.out.printf("' = %.20f\n", numerator/denominator);
    }

    public static double computeProbability(char burglary, char earthquake, char alarm, char johnCall, char maryCall) {
        double computedProbability = 0.0;
        double burglaryVal = 0.0, earthquakeVal = 0.0, alarmVal = 0.0, johnCallVal = 0.0, maryCallVal = 0.0;
        burglaryVal = bT.get("B_T");
        earthquakeVal = eT.get("E_T");
        alarmVal = aT.get("A_T|B_" + burglary + ",E_" + earthquake);
        johnCallVal = jCT.get("J_T|A_" + alarm);
        maryCallVal = mCT.get("M_T|A_" + alarm);
        if (burglary == 'F') burglaryVal = 1.00 - burglaryVal;
        if (earthquake == 'F') earthquakeVal = 1.00 - earthquakeVal;
        if (alarm == 'F') alarmVal = 1.00 - alarmVal;
        if (johnCall == 'F') johnCallVal = 1.00 - johnCallVal;
        if (maryCall == 'F') maryCallVal = 1.00 - maryCallVal;
        computedProbability = burglaryVal * earthquakeVal * alarmVal * johnCallVal * maryCallVal;
        return computedProbability;
    }

    public static Map<Character, ArrayList<Character>> generateRemainingPossibleValues(Map<Character, ArrayList<Character>> passedMap) {
        Map<Character, ArrayList<Character>> possibleVal = new HashMap<Character, ArrayList<Character>>();
        ArrayList<Character> possibleBool;
        if (!(passedMap.containsKey('B'))) {
            possibleBool = new ArrayList<Character>();
            possibleBool.add('T');
            possibleBool.add('F');
            possibleVal.put('B', possibleBool);
        }
        if (!(passedMap.containsKey('E'))) {
            possibleBool = new ArrayList<Character>();
            possibleBool.add('T');
            possibleBool.add('F');
            possibleVal.put('E', possibleBool);
        }
        if (!(passedMap.containsKey('A'))) {
            possibleBool = new ArrayList<Character>();
            possibleBool.add('T');
            possibleBool.add('F');
            possibleVal.put('A', possibleBool);
        }
        if (!(passedMap.containsKey('J'))) {
            possibleBool = new ArrayList<Character>();
            possibleBool.add('T');
            possibleBool.add('F');
            possibleVal.put('J', possibleBool);
        }
        if (!(passedMap.containsKey('M'))) {
            possibleBool = new ArrayList<Character>();
            possibleBool.add('T');
            possibleBool.add('F');
            possibleVal.put('M', possibleBool);
        }
        return possibleVal;
    }

    private static double computeConditionalProbability(Map<Character, ArrayList<Character>> conditions) {
        double sum = 0.0;
        for (int b = 0; b < conditions.get('B').size(); b++) {
            for (int e = 0; e < conditions.get('E').size(); e++) {
                for (int a = 0; a < conditions.get('A').size(); a++) {
                    for (int j = 0; j < conditions.get('J').size(); j++) {
                        for (int m = 0; m < conditions.get('M').size(); m++) {
                            sum += computeProbability(conditions.get('B').get(b), conditions.get('E').get(e), conditions.get('A').get(a), conditions.get('J').get(j), conditions.get('M').get(m));
                        }
                    }
                }
            }
        }
        return sum;
    }
}
