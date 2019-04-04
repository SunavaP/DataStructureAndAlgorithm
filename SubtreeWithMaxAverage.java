import java.util.ArrayList;
import java.util.List;

public class SubtreeWithMaxAverage {

    static ComponentNode node;

    public static void main(String[] args) {

        ComponentNode root = new ComponentNode(1);
//        ComponentNode left = new ComponentNode(0);
        ComponentNode right = new ComponentNode(2);
//        root.components.add(left);
        root.components.add(right);
//        ComponentNode left1 = new ComponentNode(110);
//        ComponentNode left2 = new ComponentNode(20);
//        ComponentNode left3 = new ComponentNode(30);
//        left.components.add(left1);
//        left.components.add(left2);
//        left.components.add(left3);
        ComponentNode right1 = new ComponentNode(3);
//        ComponentNode right2 = new ComponentNode(80);
        right.components.add(right1);
//        right.components.add(right2);

        double n = calculateaverage(root);
        max = Double.MIN_VALUE ;
        System.out.println(root.value);

    }

    static double max;

    private static double calculateaverage(ComponentNode root) {
        double sum = 0;
        int count = 0;

        System.out.println("XXX node :" + root.value + " sum:" + sum);
        if (root.components.size() == 0)
            return root.value;
        for (ComponentNode cc : root.components) {
            if (cc.components.size() > 0) {
                double tmp = calculateaverage(cc);
                sum += tmp*cc.components.size();
                System.out.println("--- node :" + cc.value + " sum:" + sum);
            } else {
                sum += cc.value;
            }
            count++;
        }

        sum = sum + root.value;
        double avg = 0.1*sum/(count+1);
        System.out.println("node :" + root.value + " sum:" + sum);
        System.out.println("node :" + root.value + " avg:" + avg);
        if (avg > max) {
            max = avg;
            node = root;
        }
        return avg;
    }

    public static class ComponentNode {

        List<ComponentNode> components;
        int value = 0;

        public ComponentNode() {

            components = new ArrayList<ComponentNode>();
        }

        public ComponentNode(int numlineschanged) {
            this.value = numlineschanged;
            this.components = new ArrayList<ComponentNode>();

        }

    }
}
