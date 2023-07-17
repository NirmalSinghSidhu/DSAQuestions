package nirmal.linkedlists;

import static nirmal.linkedlists.DoublyLinkedList.*;

public class ReverseDLL {
    public static NodeD<Integer> reverseDLL(NodeD<Integer> head){
        NodeD<Integer> previous = null , current = head ;

        while(current != null){
            previous =current.prev;
            current.prev = current.next;
            current.next = previous;
            current = current.prev;
        }
        if (previous != null) {
            head = previous.prev;
        }
        return head;
    }
    public void reverseDLL2(NodeD<Integer> head) {
        if (head == null || head.next == null) {
            return;
        }

        NodeD temp = head.next;
        head.next = head.prev;
        head.prev = temp;

        if (head.prev == null) {
            head = head.next;
        }

        reverseDLL2(head.prev);
    }

    public static void main(String[] args) {
        NodeD<Integer> head = createSampleDLL(new int[]{1,2,3,4,5,6});
        printDLL(head);
        head = reverseDLL(head);
        printDLL(head);
        NodeD<Integer> tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        printDLLReverse(tail);
    }
}
