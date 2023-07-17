package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class MergeSort {
    public static Node<Integer> mergeSort(Node<Integer> head1,Node<Integer> head2){

        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> first = head1,second = head2;
        Node<Integer> current = dummy;

        while(first != null && second != null){
            if(first.data <= second.data){
                current.next = new Node<>(first.data);
                first = first.next;
            }else{
                current.next = new Node<>(second.data);
                second = second.next;
            }
            current = current.next;
        }
        while(first != null){
            current.next = new Node<>(first.data);
            first = first.next;
            current = current.next;
        }
        while (second != null){
            current.next = new Node<>(second.data);
            second = second.next;
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node<Integer> head1 = createSampleLL(new int[] {1,3,5});
        Node<Integer> head2 = createSampleLL(new int[] {2,4,6,8});
        Node<Integer> merged = mergeSort(head1,head2);
        print(merged);

    }
}
