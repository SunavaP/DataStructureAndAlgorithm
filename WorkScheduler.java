import java.util.ArrayList;
import java.util.List;

public class WorkScheduler {

    public static void main(String[] args) {
        String pattern = "08???80";
        int total = 21;
        List<String> result = work_sched(pattern,total,4);
        System.out.println(result.toString());
    }

    private static List<String> work_sched(String s,int max_week,int max_day) {
        List<String> results = new ArrayList<>();
        int cur_week = 0;
        for(int i=0;i<s.length();++i) {
            if(s.charAt(i)!='?') {
                cur_week += Character.getNumericValue(s.charAt(i));
            }
        }
        recurse(s, 0, "", cur_week, max_week, max_day, results);
        return results;
    }

    private static void recurse(String s, int start, String partial, int cur_week, int max_week, int max_day, List<String> results) {
        if(cur_week == max_week && partial.length()==s.length()) {
            results.add(partial);
            return;
        } else if (cur_week > max_week || start >= s.length()) {
            return;
        }
        if(s.charAt(start)=='?') {
            for (int i=0;i<=max_day+1;++i) {
                recurse(s, start+1, partial+i, cur_week+i, max_week, max_day, results);
            }
        } else {
            recurse(s, start+1, partial+s.charAt(start), cur_week, max_week, max_day, results);
        }
    }
}


