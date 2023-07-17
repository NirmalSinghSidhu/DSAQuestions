package nirmal.linkedlists;

public class StartingPointOfLoop {

    public static Node<Integer> startOfLoop(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        boolean isLoop = false;

        while(slow!= null && fast != null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;

            if(slow == fast){
                isLoop = true;
                break;
            }
        }

        if(isLoop){
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            return slow; //start of the loop
        }
        return null; //No loop found
    }
    public static void main(String[] args) {

    }
}
