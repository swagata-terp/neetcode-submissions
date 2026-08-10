/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();

        Node t = head;
        Node dummy = new Node(0);
        Node prev = dummy;

        while (t != null) {
            Node newNode = new Node(t.val);
            prev.next = newNode;
            prev = newNode;
            map.put(t, newNode);
            t = t.next;
        }
        Node t2 = head;

        while (t2 != null) {
            Node deepCopy = map.get(t2);
            Node random = t2.random;
            Node randomDeepCopy = map.get(random);
            deepCopy.random = randomDeepCopy;
            t2 = t2.next;

        }
        return dummy.next;
        
    }
}
