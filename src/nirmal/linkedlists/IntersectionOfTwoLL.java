package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class IntersectionOfTwoLL {

    //here the linked lists are sorted

    public static Node<Integer> intersection(Node<Integer> head1 , Node<Integer> head2){
        if(head1 == null || head2 == null){
            return null;
        }

        Node<Integer> dummy = new Node<>(0);

        Node<Integer> first = head1;
        Node<Integer> second = head2;
        Node<Integer> current = dummy;

        while(first != null && second != null){
            if(first.data == second.data){
                current.next = new Node<>(first.data);
                current = current.next;
                first = first.next;
                second = second.next;
            } else if (first.data > second.data) {
                second = second.next;
            }else{
                first = first.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Node<Integer> head1 = createSampleLL(new int[]{1,2,3,4,5});
        Node<Integer> head2 = createSampleLL(new int[]{3,4,5,6,7});
        Node<Integer> intersection = intersection(head1,head2);
        print(intersection);
    }
}
