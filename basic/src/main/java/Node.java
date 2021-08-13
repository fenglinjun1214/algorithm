import java.util.*;

public class Node {

    private Node left;

    private Node right;

    private Integer val;

    public Node(Integer val) {
        this.val = val;
    }

    public static void  main(String[] args) {
        //逐层遍历
        /*Node root = new Node(5);

        Node left = new Node(4);
        Node right = new Node(3);

        Node left1 = new Node(2);
        Node right1 = new Node(1);
        left.left = left1;
        left.right = right1;

        Node left2 = new Node(6);
        Node right2 = new Node(7);
        Node left3 = new Node(8);
        Node right3 = new Node(9);
        left2.left = left3;
        left2.right = right3;

        right.left = left2;
        right.right = right2;

        root.left = left;
        root.right = right;*/

        Node root = new Node(2);

        Node left = new Node(2);
        Node right = new Node(2);
        /*Node left1 = new Node(3);
        Node right1 = new Node(7);*/
        /*right.left = left1;
        right.right = right1;*/
        root.left = left;
        root.right = right;

        boolean flag = isBst(root);

        /*List<Integer> alist = midSortNode(root);
        List<Integer> list = midSort(root);

        printArr(5);*/
    }

    private static List<List<Integer>> rank(Node root) {
        if(null == root) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        //逐层遍历 先进后出
        Queue<Node> queue = new LinkedList<>();
        LinkedList<Node> queue1 = new LinkedList<>();
        queue.offer(root);

        List<Integer> rootList = new ArrayList<>();
        Integer size = queue.size();
        while(queue.size() > 0) {

            Node node = queue.poll();
            rootList.add(node.val);

            size --;

            if(null != node.left) {
                queue.add(node.left);
            }
            if(null != node.right) {
                queue.add(node.right);
            }
            if(size == 0) {
                size = queue.size();
                list.add(rootList);
                rootList = new ArrayList<>();
            }
        }
        return list;
    }

    /**
     * 判断一个二叉树是bst
     * @param root
     * @return
     */
    private static boolean isBst(Node root) {
        if(null == root) {
            return false;
        }
        Long max = Long.MAX_VALUE;
        Long min = Long.MIN_VALUE;

        return isBst(root, max, min);
    }

    private static boolean isBst(Node node, Long max, Long min) {
        if(null == node) {
            return true;
        }
        Integer val = node.val;
        if(min >= node.val.longValue() || max <= node.val.longValue()) {
            return false;
        }
        return isBst(node.left, min, val.longValue()) && isBst(node.right, val.longValue(), max);

    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    private static List<Integer> centerRank(Node root) {
        if(null == root) {
            return null;
        }
        List<Integer> list = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(stack.size() > 0) {
            //先序遍历，先遍历根节点，再遍历左节点，再遍历右节点，如果左边节点有子节点，遍历完跟节点，先遍历子节点
            Node node = stack.pop();
            list.add(node.val);

            //为了先左边，后进先出，左边后进
            if(null != node.right) {
                stack.push(node.right);
            }
            if(null != node.left) {
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    private static List<Integer> rootRank(Node root) {
        if(null == root) {
            return null;
        }
        Stack<Integer> list = new Stack<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(stack.size() > 0) {
            //先序遍历，先遍历根节点，再遍历左节点，再遍历右节点，如果左边节点有子节点，遍历完跟节点，先遍历子节点
            Node node = stack.pop();
            list.push(node.val);

            //为了先左边，后进先出，左边后进
            if(null != node.right) {
                stack.push(node.right);
            }
            if(null != node.left) {
                stack.push(node.left);
            }
        }
        return list;
    }

    private static void sort(Node root) {
        if(null == root) {
            return;
        }
        System.out.println(root.val);
        if(null != root.left) {
            sort(root.left);
        }
        if(null != root.right) {
            sort(root.right);
        }
    }

    /**
     * 中序遍历
     */
    private static List<Integer> midSortNode(Node root) {
        if(null == root) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if(null != root.left) {
            List<Integer> leftList = midSortNode(root.left);
            list.addAll(leftList);
        }
        list.add(root.val);
        if(null != root.right) {
            List<Integer> rightList = midSortNode(root.right);
            list.addAll(rightList);
        }
        return list;
    }


    /**
     * 中序遍历  非递归
     */
    private static List<Integer> midSort(Node root) {
        if(null == root) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();

        while(null != root && stack.size()>0) {
            if(null != root.left) {
                root = root.left;
                stack.push(root);
            } else {

                //如果左节点是空的，根节点出栈，找到右节点
                root = stack.pop();
                list.add(root.val);
                if(null != root.right) {
                    root = root.right;
                    stack.push(root);
                }
            }
        }
        return list;
    }

    /**
     * 递归后续遍历
     * @param root
     */
    private static void afterSort(Node root) {
        if(null == root) {
            return;
        }
        if(null != root.left) {
            afterSort(root.left);
        }
        if(null != root.right) {
            afterSort(root.right);
        }
        System.out.println(root.val);

    }

    /**
     * 非递归后续遍历
     * @param root
     */
    private static List<Integer> afterSortNo(Node root) {
        if(null == root) {
            return null;
        }

        //后续是左、右、根
        //那先进行先序遍历
        Stack<Node> stack1 = new Stack<>();
        stack1.push(root);
        Stack<Node> stack2 = new Stack<>();

        while(stack1.size() > 0) {
            Node node = stack1.pop();
            stack2.push(node);
            if(null != node.left) {
                stack1.push(node.left);
            }

            if(null != node.right) {
                stack1.push(node.right);
            }

        }

        List<Integer> list = new ArrayList<>();
        while(stack2.size()>0) {
            list.add(stack2.pop().val);
        }

        return list;
    }


    private static void rootSort(Node root) {
        if(null == root) {
            return;
        }
        if(null != root.left) {
            sort(root.left);
        }
        System.out.println(root.val);
        if(null != root.right) {
            sort(root.right);
        }
    }

    private static void  printArr(Integer n) {
        int[][] arr = new int[n][n];
        int i =0; int j =0; int k =0;
        while(k < n*n) {
            //右行
            while(k < n*n && j < n && arr[i][j] == 0) {
                arr[i][j++] = k++;
            }
            i++;j--;
            //下行
            while(k < n*n &&  i < n && arr[i][j] == 0) {
                arr[i++][j] = k++;
            }
            j--;i--;
            //左行
            while(k < n*n &&  j>-1 && arr[i][j] == 0) {
                arr[i][j--] = k++;
            }
            i--;j++;
            //上行
            while(k < n*n &&  i>0 && arr[i][j] == 0) {
                arr[i--][j] = k++;
            }
            j++;i++;
        }
        for(int m=0;m<n;m++) {
            for(int p=0;p<n;p++) {
                System.out.print(arr[m][p] + "   ");
            }
            System.out.println();
        }

        /*int[][] matrix = new int[n][n];
        int i = 1;
        int row = 0, col = 0;
        while (i <= n * n) {
            while (i <= n * n && col < n && matrix[row][col] == 0) matrix[row][col++] = i++;//向右
            row++; col--;
            while (i <= n * n && row < n && matrix[row][col] == 0) matrix[row++][col] = i++;//向下
            row--; col--;
            while (i <= n * n && col > -1 && matrix[row][col] == 0) matrix[row][col--] = i++;//向左
            row--;col++;
            while (i <= n * n && row > -1 && matrix[row][col] == 0) matrix[row--][col] = i++;//向上
            row++; col++;
        }
        for(int m=0;m<n;m++) {
            for(int p=0;p<n;p++) {
                System.out.print(matrix[m][p]);
            }
            System.out.println();
        }*/


    }




}