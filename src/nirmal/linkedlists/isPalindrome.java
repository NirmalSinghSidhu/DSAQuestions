package nirmal.linkedlists;

import java.util.Stack;

import static nirmal.linkedlists.LinkedList.createSampleLL;

public class isPalindrome {
    public static boolean isPalindromeLL(Node<Integer> head){
        if(head == null || head.next == null){
            return true;
        }
        Node<Integer> slow = head , fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse
        Node<Integer> reversed = reverse(slow);
        Node<Integer> first = head;

        while(reversed != null){
            if(first.data != reversed.data){
                return false;
            }
            first = first.next;
            reversed = reversed.next;
        }
        return true;
    }
    private static Node<Integer> reverse(Node<Integer> node) {
        Node<Integer> prev = null;
        Node<Integer> current = node;
        Node<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static boolean isPalindromeLL2(Node<Integer> head){
        if(head == null || head.next == null){
            return true;
        }
        Node<Integer> slow = head , fast = head;
        Stack<Integer> stack = new Stack<>();
        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            int top = stack.pop();
            if(top != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node<Integer> head = createSampleLL(new int[]{1,2,2,2,1});
        Node<Integer> head1 = createSampleLL(new int[]{1,2,4,3,3,2,1});
        System.out.println(isPalindromeLL2(head));
        System.out.println(isPalindromeLL2(head1));
    }

}
