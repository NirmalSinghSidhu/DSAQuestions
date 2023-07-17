package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;

public class DetectALoop {
    public static boolean isLoopIterative(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;

    }

    public static boolean isLoopRecursive(Node<Integer> head){
        if(head == null || head.next == null){
            return false;
        }

        if(head.next == head){
            return true;
        }

        Node<Integer> nextNode = head.next;
        head.next = head;

        return isLoopRecursive(nextNode);
    }
    public static void main(String[] args) {
        Node<Integer> head = createSampleLL(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        Node<Integer> head1 = createSampleLL(new int[] {7,8,9,10,11});

        //create a cycle in the linked list head1
        Node<Integer> tail = head1;
        while(tail .next != null){
            tail = tail.next;
        }
        tail.next=head1;

        System.out.println(isLoopIterative(head));
        System.out.println(isLoopIterative(head1));
        System.out.println(isLoopRecursive(head));
        System.out.println(isLoopRecursive(head1));
    }
}
