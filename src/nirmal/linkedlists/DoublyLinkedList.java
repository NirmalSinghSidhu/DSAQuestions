package nirmal.linkedlists;

public class DoublyLinkedList {
    NodeD<Integer> head;
    NodeD<Integer> tail;

    public static NodeD<Integer> createSampleDLL(int [] arr){
        NodeD<Integer> head = new NodeD<>(arr[0]);
        NodeD<Integer> temp = head ,newNode;
        for(int i = 1;i< arr.length;i++){
            newNode = new NodeD<>(arr[i]);
            newNode.prev = temp;
            temp.next=newNode;
            temp = newNode;
        }
        return head;
    }

    public static void printDLL(NodeD<Integer> head){
        if(head == null){
            return;
        }
        NodeD<Integer> current = head;
        while(current.next != null){
            System.out.print(current.data +" -> ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println("");
    }
    public static void printDLLReverse(NodeD<Integer> tail){
        NodeD<Integer> current = tail;
        while(current.prev != null){
            System.out.print(current.data +" -> ");
            current = current.prev;
        }
        System.out.print(current.data);
        System.out.println("");
    }
}
