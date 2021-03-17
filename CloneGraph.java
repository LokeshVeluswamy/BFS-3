//Time Complexity: o(v+e)
//Space Complexity: o(v)
//Expln: perform bfs on the neighbors by adding it to the queue only when the map doesnt contain the key.
//IF it doesnt contain create a key and a copy node and keep updating it and its neighbors.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> imap = new HashMap<>();
        q.add(node);
        
        while(!q.isEmpty())
        {
            int len = q.size();
            for(int i = 0; i < len; i++)
            {
                Node currnode = q.poll();
                if(!imap.containsKey(currnode.val))
                {
                    Node copynode = new Node(currnode.val);
                    imap.put(currnode.val, copynode);
                }
                for(Node neigh: currnode.neighbors)
                {
                    if(!imap.containsKey(neigh.val))
                    {
                        Node copychild = new Node(neigh.val);
                        imap.put(neigh.val, copychild); 
                        q.add(neigh);
                    }
                    imap.get(currnode.val).neighbors.add(imap.get(neigh.val));
                }
            }
        }
        return imap.get(node.val);
    }
}