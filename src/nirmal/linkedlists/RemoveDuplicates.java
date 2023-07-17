package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class RemoveDuplicates {
    // Remove duplicates from sorted linked list

    public static void removeDuplicatesSorted(Node<Integer> head){
        if(head == null){
            return;
        }

        Node current = head;

        while( current.next != null){
            if(current.data == current.next.data){
                current.next=current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = createSampleLL(new int[]{1,2,3,3,3,4,5});
        removeDuplicatesSorted(head);
        print(head);
    }
}
