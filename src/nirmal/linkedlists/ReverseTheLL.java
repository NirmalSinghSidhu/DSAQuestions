package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class ReverseTheLL<T> {
    //iterative Approach
    public static Node<Integer> reverseTheLinkedList(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> current = head, prev= null,frd = null;

        while(current != null){
            frd = current.next;
            current.next=prev;
            prev= current;
            current = frd;
        }
        return prev;
    }

    //recursive Approach

    public static Node<Integer> reverseLL2(Node<Integer> head){
        if(head == null || head.next== null){
            return head;
        }
        Node<Integer> smallHead =reverseTheLinkedList(head.next);
        head.next.next =head;
        head.next = null;
        return smallHead;
    }

    public static void main(String[] args) {
        Node<Integer> head = createSampleLL(new int[]{1,2,3});
        print(head);
        head= reverseTheLinkedList(head);
        print(head);

        Node<Integer> head1 = createSampleLL(new int[]{4,5,6,7});
        print(head1);
        head1 = reverseLL2(head1);
        print(head1);
    }
}
