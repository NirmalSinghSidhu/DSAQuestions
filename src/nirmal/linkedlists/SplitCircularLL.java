package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;

public class SplitCircularLL {
    public static Node<Integer>[] splitCircular(Node<Integer> head){
        if(head == null){
            return null;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node<Integer> head1 = head;
        Node<Integer> head2 = slow.next;
        slow.next = head1;
        fast.next = head2;
        return new Node[]{head1,head2};
    }

    private static void print(Node<Integer> head){
        Node<Integer> curr = head;
        if(head == null){
            return;
        }
        do{
            System.out.print(curr.data +" ->");
            curr = curr.next;
        }while (curr != head);
    }

    public static void main(String[] args) {
        Node<Integer> head1 = createSampleLL(new int[] {7,8,9,10,11});

        //create a cycle in the linked list head1
        Node<Integer> tail = head1;
        while(tail .next != null){
            tail = tail.next;
        }
        tail.next=head1;
        Node<Integer> first = splitCircular(head1)[0];
        Node<Integer> second = splitCircular(head1)[1];
        print(first);
        print(second);
    }
}
