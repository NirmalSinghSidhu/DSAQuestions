package nirmal.linkedlists;

import java.util.ArrayList;
import java.util.HashSet;

import static nirmal.linkedlists.DoublyLinkedList.createSampleDLL;
import static nirmal.linkedlists.DoublyLinkedList.printDLL;

public class PairSumInDLL {
   public static ArrayList<ArrayList<Integer>> findPair(NodeD<Integer> head,int sum){
      NodeD<Integer> first = head;
      NodeD<Integer> second = head;

      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      //traversing till tail
      while (second.next != null) {
         second = second.next;
      }
      while (first != null && second != null && first != second && second.next != first) {
         int currentSum = first.data + second.data;

         if (currentSum == sum) {
           ArrayList<Integer> list = new ArrayList<>();
           list.add(first.data);
           list.add(second.data);
           ans.add(list);
            first = first.next;
            second = second.prev;
         } else if (currentSum < sum) {
            first = first.next;
         } else {
            second = second.prev;
         }
      }
      return ans;
   }
    public static ArrayList<ArrayList<Integer>> findPairs2(NodeD<Integer> head,int sum) {
        HashSet<Integer> set = new HashSet<>();
        NodeD<Integer> current = head;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (current != null) {
            int target = sum - current.data;
            if (set.contains(target)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(target);
                list.add(current.data);
                ans.add(list);
            }
            set.add(current.data);
            current = current.next;
        }
        return ans;
    }

   public static void main(String[] args) {
      NodeD<Integer> head = createSampleDLL(new int[]{1,2,3,4,5,6,6,10,11,20});
      printDLL(head);
      ArrayList<ArrayList<Integer>> ans = findPairs2(head,15);
      System.out.println(ans);

   }
}
