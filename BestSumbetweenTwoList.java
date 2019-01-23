import java.util.*;

public class BestSumbetweenTwoList {
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

//        int sum = 0;
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
        HashMap<Integer, List<Integer>> distanceMap = new HashMap<Integer, List<Integer>>();
        while (frontStart != frontBack || backEndBack != backEndStart) {
            int sum = frontEnd.get(frontStart).get(1) + backEnd.get(backEndBack).get(1);
            if (sum <= memorySpace) {
                if (Math.abs(sum - memorySpace) <= diff) {
                    diff = Math.abs(sum - memorySpace);
                    int fro = frontEnd.get(frontStart).get(1);
                    int bac = backEnd.get(backEndBack).get(1);
                    int currentFro = frontStart;
                    while(currentFro != frontBack && fro == frontEnd.get(currentFro).get(1)) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(frontEnd.get(currentFro).get(0));
                        temp.add(backEnd.get(backEndBack).get(0));
                        distanceMap.put(diff, temp);
                        currentFro++;
                    }
                    int currentBac = backEndBack - 1;
                    while(currentBac != backEndStart && bac == backEnd.get(currentBac).get(1)) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(frontEnd.get(frontStart).get(0));
                        temp.add(backEnd.get(currentBac).get(0));
                        distanceMap.put(diff, temp);
                        currentBac--;
                    }
                    frontStart = currentFro;
                    backEndBack = currentBac;
                }
                if(frontStart < frontBack)
                    frontStart++;
            } else {
                if(backEndBack > backEndStart)
                    backEndBack--;
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : distanceMap.entrySet()) {
            if (diff == entry.getKey()) {
                int frontPosition = entry.getValue().get(0);
                int backPosition = entry.getValue().get(1);
                System.out.print("Total Memory :" + memorySpace + "\nMemory :" + diff + "\n" + frontEnd.get(frontPosition).toString() + backEnd.get(backPosition).toString());
                System.out.println();
            }
        }
    }
}
