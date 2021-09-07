import sun.awt.image.ImageWatched;

import java.util.*;

public class Topk {


    static class Node {
        Node left;
        Node right;
        Integer val;
        public Node(Integer val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        Node leftNode = new Node(9);
        Node rightNode = new Node(20);
        node.left = leftNode;
        Node leftNode2 = new Node(15);
        Node rightNode2 = new Node(7);
        rightNode.left = leftNode2;
        rightNode.right = rightNode2;
        node.right = rightNode;

        Queue<Node> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(node);
        while(q.size()>0) {
            Node root = q.poll();
            if(null != root.left) {
                q.add(root.left);
                list.add(root.left.val);
            }
            if(null != root.right) {
                q.add(root.right);
            }
        }
        System.out.println(list.stream().reduce((i, j) -> i + j));
    }


    public static List<Integer> solutionByHeap(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }
}
