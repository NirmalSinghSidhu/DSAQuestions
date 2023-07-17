package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class AddTwoNumbers {

    public static Node<Integer> addTwoNumbers(Node<Integer> head1 , Node<Integer> head2){
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> current = dummy;
        int carry = 0;

        Node<Integer> first = head1;
        Node<Integer> second = head2;

        while(first != null || second != null){
            int x = (first != null) ? first.data : 0;
            int y = (second != null )? second.data : 0;

            int sum = x + y + carry;
            carry = sum /10;

            current.next = new Node<>(sum%10);
            current = current.next;

            if(first != null){
                first = first.next;
            }

            if(second != null){
                second = second.next;
            }
        }

        if(carry > 0){
            current.next = new Node<>(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node<Integer> head1 = createSampleLL(new int[]{1,2,3});
        Node<Integer> head2 = createSampleLL(new int[]{4,5,6});
        Node<Integer> sum = addTwoNumbers(head1,head2);
        print(sum);
    }

}
