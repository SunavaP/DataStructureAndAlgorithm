import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bnett {

    static Map<String, Double> burglaryTT = new HashMap<String, Double>();
    static Map<String, Double> earthquakeTT = new HashMap<String, Double>();
    static Map<String, Double> alarmTT = new HashMap<String, Double>();
    static Map<String, Double> johnCallTT = new HashMap<String, Double>();
    static Map<String, Double> maryCallTT = new HashMap<String, Double>();
    static Map<Character, ArrayList<Character>> conditions, givenValues;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (args.length < 1 || args.length > 6) {
            System.out.println("Wrong number of arguments.Should be between 1-6.\n");
            System.exit(0);
        }
        burglaryTT.put("B_T", 0.001);
        earthquakeTT.put("E_T", .002);
        /**TT values of Alarm*/
        alarmTT.put("A_T|B_T,E_T", 0.95);
        alarmTT.put("A_T|B_T,E_F", 0.94);
        alarmTT.put("A_T|B_F,E_T", 0.29);
        alarmTT.put("A_T|B_F,E_F", 0.001);
        /**TT values of JohnCalls*/
        johnCallTT.put("J_T|A_T", 0.90);
        johnCallTT.put("J_T|A_F", 0.05);
        /**TT values of MaryCall*/
        maryCallTT.put("M_T|A_T", 0.70);
        maryCallTT.put("M_T|A_F", 0.01);
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
//        double numerator = computeConditionalProbability(conditions);
//        double denominator = counter == 1?1:computeConditionalProbability(givenValues);

        double calcProb1=0.0,denomVal=0.0;
        /**Computing the numerator value/the value when no given is present.*/
        for(int b=0;b<conditions.get('B').size();b++) {
            for(int e=0;e<conditions.get('E').size();e++) {
                for(int a=0;a<conditions.get('A').size();a++) {
                    for(int j=0;j<conditions.get('J').size();j++) {
                        for(int m=0;m<conditions.get('M').size();m++) {
                            //System.out.println(conditions.get('B').get(i)+"--"+conditions.get('E').get(j)+"--"+conditions.get('A').get(k)+"--"+conditions.get('J').get(l)+"--"+conditions.get('M').get(m));
                            calcProb1+=computeProbability(conditions.get('B').get(b),conditions.get('E').get(e),conditions.get('A').get(a),conditions.get('J').get(j),conditions.get('M').get(m)); /**Calling the different possible combination of possible values of the variables B,E,A,J,M*/
                        }
                    }
                }
            }

        }
        //System.out.println(calcProb1);
        //System.out.println("-------------------------------");
        if (counter==1) {
            /**Given is present so calculating the  denominator*/
            for(int i=0;i<givenValues.get('B').size();i++) {
                for(int j=0;j<givenValues.get('E').size();j++) {
                    for(int k=0;k<givenValues.get('A').size();k++) {
                        for(int l=0;l<givenValues.get('J').size();l++) {
                            for(int m=0;m<givenValues.get('M').size();m++) {
                                //System.out.println(givenValues.get('B').get(i)+"--"+givenValues.get('E').get(j)+"--"+givenValues.get('A').get(k)+"--"+givenValues.get('J').get(l)+"--"+givenValues.get('M').get(m));
                                denomVal+=computeProbability(givenValues.get('B').get(i),givenValues.get('E').get(j),givenValues.get('A').get(k),givenValues.get('J').get(l),givenValues.get('M').get(m));/**Calling the different possible combination of possible values of the variables B,E,A,J,M*/
                            }
                        }
                    }
                }
            }
            //System.out.println(denomVal);
            calcProb1=calcProb1/denomVal;/**Calculating the probability when given is present*/

        }

        System.out.print("Probability of the statement ' ");
        for (int s = 0; s < args.length; s++) {
            System.out.print(args[s] + " ");
        }
        System.out.printf("' = %.20f\n", calcProb1);
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

    public static double computeProbability(char burglary, char earthquake, char alarm, char johnCall, char maryCall) {
        double computedProbability = 0.0;
        double burglaryVal = 0.0, earthquakeVal = 0.0, alarmVal = 0.0, johnCallVal = 0.0, maryCallVal = 0.0;
        burglaryVal = burglaryTT.get("B_T");
        earthquakeVal = earthquakeTT.get("E_T");
        alarmVal = alarmTT.get("A_T|B_" + burglary + ",E_" + earthquake);
        johnCallVal = johnCallTT.get("J_T|A_" + alarm);
        maryCallVal = maryCallTT.get("M_T|A_" + alarm);
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
}
