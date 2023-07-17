package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;

public class FindMiddleOfLL {
    public static Node<Integer> findMiddle(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node<Integer> head1 = createSampleLL(new int[]{1,2,3,4,5});
        System.out.println(findMiddle(head1).data);
    }
}
