package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.print;

public class DeleteLoop {

    //exmaple 1-2-3-4-5-2
    public static void deleteLoop(Node<Integer> head){
        Node<Integer> slow = head, fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(slow == fast){
            slow = head;

            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }

            fast.next= null; //removing the loop
        }
    }

    public static void main(String[] args) {
        // creating the linkedlist with a cycle
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        Node<Integer> head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        //cycle link
        node5.next = node2;

        deleteLoop(head);
        print(head);
    }
}
