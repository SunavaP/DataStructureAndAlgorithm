import java.util.*;

public class KNearestNeighbours {
    public static void main(String[] args) {

        List<List<Integer>> restuarentCoordinate = new ArrayList<List<Integer>>();
        int totalNumber = 5;
        int searchRestuarent = 3;
        int x[] = {1,2,4,3,2};
        int y[] = {-3,2,1,5,1};
        for(int i=0;i<totalNumber; i++){
            List<Integer> w = new ArrayList<Integer>();
            w.add(x[i]);
            w.add(y[i]);
            restuarentCoordinate.add(new ArrayList(w));
        }
        nearestRestuarent(totalNumber,restuarentCoordinate,searchRestuarent);
    }

    public static void nearestRestuarent(int totalNumber,List<List<Integer>> restuarentCoordinate, int searchRestuarent) {
        if(totalNumber<searchRestuarent){
            return ;
        }

        List<List<Integer>> searchCoordinate = new ArrayList<List<Integer>>();
        TreeMap<Double,List<Integer>> distanceMap = new TreeMap<Double, List<Integer>>();
        double distance = 0;
        for(List resList:restuarentCoordinate){
            distance = distance(Integer.valueOf((Integer) resList.get(0)),Integer.valueOf((Integer) resList.get(1)));
            distanceMap.put(distance,resList);
        }
        for (Map.Entry<Double,List<Integer>> entry : distanceMap.entrySet()) {
            searchCoordinate.add(entry.getValue());
            System.out.print(entry.getKey()+" : "+entry.getValue());
            System.out.println();
        }
    }

    private static double distance(int a,int b) {
        int totalDistance = (a*a) + (b*b);
        return Math.sqrt(totalDistance);
    }
}
