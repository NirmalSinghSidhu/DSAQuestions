package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class Add1ToNumber {
    //Approach reverse the list and add 1
    // 1-2-3
    //3-2-1 == 4-2-1
    // 124   129 921 = 031 130

    public static Node<Integer> addOne(Node<Integer> head) {
        head = reverse(head);
        int carry = 1;
        Node<Integer> current = head;

        while (current != null) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;
            current = current.next;
        }

        if (carry > 0) {
            Node newNode = new Node<>(carry);
            newNode.next = head;
            head = newNode;
        }
        head = reverse(head);
        return head;
    }

    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> current = head, prev = null, frd = null;
        while (current != null) {
            frd = current.next;
            current.next = prev;
            prev = current;
            current = frd;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node<Integer> head = createSampleLL(new int[]{1,2,3});
        head = addOne(head);
        print(head);
    }
}
