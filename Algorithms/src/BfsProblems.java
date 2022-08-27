import java.util.*;

class BfsProblems {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

//        findAllRightNodes(root);
//        System.out.println("Min Depth Value is = " + findMinDepth(root));
//        printTree(root);
        printNodes(root);
    }

    private static void printTree(Node node) {
        HashMap<Integer, ArrayList<Integer>> treeMap = new HashMap<>();
        mapTreeLevels(node, treeMap, 1);
        LinkedList<List<Integer>> reverseLevel = new LinkedList<>();
//        Top to Bottom
        treeMap.forEach((level, nodeValues) -> {
            System.out.print(treeMap.get(level));
            reverseLevel.addFirst(treeMap.get(level));
        });
        System.out.println();
//        Bottom To Top
        reverseLevel.forEach(System.out::print);
    }

    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                          Integer key, Integer value) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }

    public static void printNodes(Node node) {
        if (node == null) return;

        int level = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();

        insertIntoMultiMap(map, level, node.getData());
        Queue<Node> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();

        if (node.left != null && node.right != null) {
            q1.add(node.left);
            q2.add(node.right);
        }

        while (!q1.isEmpty()) {
            level++;
            int n = q1.size();
            while (n-- > 0) {
                Node x = q1.poll();
                if (x != null) {
                    insertIntoMultiMap(map, level, x.getData());
                    if (x.left != null) q1.add(x.left);
                    if (x.right != null) q1.add(x.right);
                }
                Node y = q2.poll();
                if (y != null) {
                    map.get(level).add(y.getData());
                    if (y.right != null) q2.add(y.right);
                    if (y.left != null) q2.add(y.left);
                }
            }
        }

        for (int i = map.size(); i > 0; i--) {
            System.out.print(map.get(i));
        }
    }

    private static void mapTreeLevels(Node node, HashMap<Integer, ArrayList<Integer>> treeMap, int level) {
        if (node == null) return;
        ArrayList<Integer> nodes = new ArrayList<>();
        if (treeMap.containsKey(level)) nodes = treeMap.get(level);
        nodes.add(node.getData());
        treeMap.put(level, nodes);
        mapTreeLevels(node.left, treeMap, level + 1);
        mapTreeLevels(node.right, treeMap, level + 1);
    }

    private static int findMinDepth(Node node) {
        if (node == null) return 0;
        int l = findMinDepth(node.left);
        int r = findMinDepth(node.right);
        if (node.left == null) return r + 1;
        if (node.right == null) return l + 1;
        return Math.min(l, r) + 1;
    }

    private static void findAllRightNodes(Node root) {
        Map<Integer, Integer> rightNodes = new HashMap<>();
        printAllRightNodes(rightNodes, 1, root);
        rightNodes.forEach((level, rightNode) -> System.out.print(rightNode + " "));
    }

    private static void printAllRightNodes(Map<Integer, Integer> rightNodes, int level, Node root) {
        if (root == null) return;
//        Add this condition to get left view of tree:
//        if (!rightNodes.containsKey(level))
        rightNodes.put(level, root.getData());
        printAllRightNodes(rightNodes, level + 1, root.left);
        printAllRightNodes(rightNodes, level + 1, root.right);
    }
}

class Node {
    private final int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public int getData() {
        return this.data;
    }
}
