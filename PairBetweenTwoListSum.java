import java.util.*;

public class PairBetweenTwoListSum {
    public static void main(String[] args) {
        List<List<Integer>> frontEnd = new ArrayList<List<Integer>>();
        List<List<Integer>> backEnd = new ArrayList<List<Integer>>();
        int memorySpace = 5;
        int x[] = {1, 2, 4, 3, 2};
        int y[] = {3, 2, 1, 5, 1};
        for (int i = 0; i < memorySpace; i++) {
            List<Integer> w = new ArrayList<Integer>();
            List<Integer> u = new ArrayList<Integer>();
            w.add(i + 1);
            w.add(x[i]);
            frontEnd.add(new ArrayList(w));
            u.add(i + 1);
            u.add(y[i]);
            backEnd.add(new ArrayList(u));
        }
        bestSum(memorySpace, frontEnd, backEnd);
    }

    public static void bestSum(int memorySpace, List<List<Integer>> frontEnd, List<List<Integer>> backEnd) {

        List<List<Integer>> pairedProgram = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> distanceMap = new HashMap<Integer, List<Integer>>();
        int i = 0;
        for (i = 0; i < frontEnd.size(); ++i) {
            if(distanceMap.containsKey(frontEnd.get(i).get(1))){
                List<Integer> temp = distanceMap.get(frontEnd.get(i).get(1));
                temp.add(frontEnd.get(i).get(0));
                distanceMap.put(frontEnd.get(i).get(1), new ArrayList<Integer>(frontEnd.get(i).get(0)));
            } else {
                distanceMap.put(frontEnd.get(i).get(1), new ArrayList<Integer>(frontEnd.get(i).get(0)));
            }
        }
        Collections.sort(frontEnd, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                // Sort the lists using the starting position (second element in the list)
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        Collections.sort(backEnd, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                // Sort the lists using the starting position (second element in the list)
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        int frontStart = 0;
        int frontBack = frontEnd.size() - 1;
        int backEndStart = 0;
        int backEndBack = backEnd.size() - 1;
        int diff = Integer.MAX_VALUE;
        while (frontStart <= frontBack && backEndBack >= backEndStart) {
            int sum = frontEnd.get(frontStart).get(1) + backEnd.get(backEndBack).get(1);
            if (Math.abs(sum - memorySpace) <= diff) {
                diff = Math.abs(sum - memorySpace);
            }
            if (sum > memorySpace) {
                    backEndBack--;
            } else {
                    frontStart++;
            }
        }

        for (i = 0; i < backEnd.size(); ++i) {
            if (distanceMap.containsKey(memorySpace - backEnd.get(i).get(1)+diff)) {
                System.out.print("Total Memory :" + memorySpace + "\nMemory :" + diff + "\n"
//                        + frontEnd.get(distanceMap.get(memorySpace - backEnd.get(i).get(1)+diff)).
                        + backEnd.get(i).toString());
                System.out.println();
            }
        }
    }
}
