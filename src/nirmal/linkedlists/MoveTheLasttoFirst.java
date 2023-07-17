package nirmal.linkedlists;

public class MoveTheLasttoFirst {

    public static Node<Integer> moveLastToFirst(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }

        Node current = head;
        Node prev = null;

        while(current.next != null){
            prev = current;
            current= current.next;
        }
        prev.next=null;
        current.next=head;
        head=current;
        return head;
    }

    public static Node<Integer> moveLastToFirstRecursive(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> rest = moveLastToFirstRecursive(head.next);
        head.next.next = head;
        head.next=null;
        return rest;
    }
    public static void main(String[] args) {

    }
}
