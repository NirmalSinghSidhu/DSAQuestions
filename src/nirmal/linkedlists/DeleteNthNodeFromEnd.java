package nirmal.linkedlists;

import static nirmal.linkedlists.LinkedList.createSampleLL;
import static nirmal.linkedlists.LinkedList.print;

public class DeleteNthNodeFromEnd {
    public static Node<Integer> deleteNthFromEnd(Node<Integer> head , int n){
        Node<Integer> curr = head;
        int length = 0;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        curr = head;
        if(n>=length){
            return head;
        }
       for(int i = 0 ; i < length - n-1;i++){
           curr = curr.next;
       }
       curr.next=curr.next.next;
       return head;
    }
    public static void main(String[] args) {
       Node<Integer> head = createSampleLL(new int[]{1,2,3,4,5,6});
       print(head);
       head = deleteNthFromEnd(head,6);
       print(head);
    }
}
