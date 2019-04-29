import java.util.*;

public class FIndTheLeastAverage {


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

        ComponentNode n = getFastestComponent(root);
        System.out.println(n.value);

    }


    public static double helper(ComponentNode rootComponent) {

        LinkedList<ComponentNode> stack = new LinkedList<>();
        stack.push(rootComponent);
        double valuesSum = 0;
        int nodesCount = 0;

        stack.addLast(rootComponent);
        while (!stack.isEmpty()) {
            ComponentNode v = stack.removeLast();
            nodesCount++;
            valuesSum += v.value;
            stack.addAll(v.components);
        }
        return valuesSum / nodesCount;

    }


    public static ComponentNode getFastestComponent(ComponentNode rootComponent) {
        Queue<ComponentNode> q = new LinkedList<ComponentNode>();
        q.add(rootComponent);

        ArrayList<ComponentNode> internalList = new ArrayList<ComponentNode>();
        while (!q.isEmpty()) {
            ComponentNode curr = q.peek();
            q.remove();
//            boolean isInternal = false;
            if (!(curr.components.size() == 0)) {
//                isInternal = true;
                internalList.add(curr);
                q.addAll(curr.components);
            }
//            if (isInternal) {
//                ComponentNode k = curr;
//            }
        }
        int position = 0;
        Double avg = Double.MIN_VALUE;
        for (int i = 0; i < internalList.size(); ++i) {
            Double cur = helper(internalList.get(i));
            System.out.println("node :" + internalList.get(i).value + " sum:" + cur);
            if (avg < cur) {
                position = i;
                avg = cur;
            }
        }
        return internalList.get(position);
    }

}