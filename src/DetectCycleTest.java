public class DetectCycleTest {

    public static class Node {
        int data;
        Node next;
    }

    // utilize fast and slow pointer strategy
    public static boolean hasCycle(Node head) {
        Node fast = head;

        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            head = head.next;

            System.out.println("fast data: " + fast.data + ", head data: " + head.data);

            if(head.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Node node1 = new Node();
        node1.data = 1;


        Node node2 = new Node();
        node2.data = 2;

        node1.next = node2;

        Node node3 = new Node();
        node3.data = 3;

        node2.next = node3;

        Node node4 = new Node();
        node4.data = 4;

        node3.next = node4;

        Node node5 = new Node();
        node5.data = 5;

        node4.next = node5;

        node5.next = node1;

        System.out.println(hasCycle(node1));

    }
}
