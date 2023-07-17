package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;

public class isCircular {
    public static boolean isCircularLL(Node<Integer> head) {
        if (head == null) {
            return false;
        }

        Node<Integer> current = head;

        while (current != null && current.next != head) {
            current = current.next;
        }

        return (current != null);
    }

    public static boolean isCircularLL2(Node<Integer> head){
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node<Integer> head1 = createSampleLL(new int[]{1,2,3,4,5});
        System.out.println(isCircularLL(head1));
        System.out.println(isCircularLL2(head1));
    }
}
