package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class reverseInGroups {

    //Iterative Approach and recursive
    public static Node<Integer> reverseInGroups(Node<Integer> head, int k) {
        Node<Integer> current = head, prev = null, frd = null;
        int count = 0;
        while (current != null && count < k) {
            frd = current.next;
            current.next = prev;
            prev = current;
            current = frd;
            count++;
        }
        if (frd != null) {
            head.next = reverseInGroups(frd, k);
        }
        return prev;
    }


    public static void main(String[] args) {
        Node<Integer> head = createSampleLL(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        print(head);

        head = reverseInGroups(head, 3);
        print(head);
    }
}
