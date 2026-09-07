class Solution {
    private HashMap<Node, Node> map = new HashMap<>(); // original -> cloned node

    public Node cloneGraph(Node node) {
        if (node == null) return null; // handle empty graph

        if (map.containsKey(node)) return map.get(node); // return existing clone

        Node clone = new Node(node.val); // create clone of current node
        map.put(node, clone); // store before visiting neighbors

        for (Node neighbor : node.neighbors) { // visit every neighbor
            clone.neighbors.add(cloneGraph(neighbor)); // clone and connect neighbor
        }

        return clone; // return cloned graph
    }
}