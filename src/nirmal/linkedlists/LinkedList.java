package nirmal.linkedlists;


public class LinkedList {
    Node head;
    public static Node<Integer> createSampleLL(int [] arr){
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> temp = head ,newNode;
        for(int i = 1;i< arr.length;i++){
            newNode = new Node<>(arr[i]);
            temp.next=newNode;
            temp = newNode;
        }
        return head;
    }

    public static void print(Node<Integer> head){
        Node<Integer> current = head;
        while(current.next != null){
            System.out.print(current.data +" -> ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println("");
    }
}
