package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class DeleteNode {
    public static Node<Integer> deleteNode(Node<Integer> head,Node<Integer> node){
        if (node == null || head == null) {
            return null;
        }

        if (node == head) {
            head = node.next;
        }

        Node current = head;
        while (current.next != node) {
            current = current.next;
        }
        current.next = node.next;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = createSampleLL(new int[] {7,8,9,10,11});
        Node<Integer> node = head.next.next.next;
        head = deleteNode(head,node);
        print(head);
    }
}
