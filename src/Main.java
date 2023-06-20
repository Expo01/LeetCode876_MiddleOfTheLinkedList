import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}


// TOP SOLUTION
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) // when fast variable == null, slow is at middle.
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

// while loop for counter. middle == counter/2 + 1. seceond while loop with criteria if tempCount = middle,
// reeturn that node. this i O(2n), not my favorite.

//1,2,3,4,5 null
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 1;
        ListNode tempHead = head;
        while (tempHead.next != null) {
            tempHead = tempHead.next;
            length++;
        }
        int middle = (length / 2) + 1;
        int tempCount = 1;
        while (middle > tempCount) {
            head = head.next;
            tempCount++;
        }
        return head; //mutating pointer

    }
}

// option 2: while loop where a map stores <Integer, Node> where coutner similarly found, and middle key seaerched
// and returns node. should be faster but more space used. O(n) for mapping, O(1) retrieval
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 1;
        // Map<Integer, ListNode> m = new HashMap<>(); ListNode not allowed as value
        Map<Integer, Object> m = new HashMap<>();
        ListNode tempHead = head;
        while (tempHead.next != null) {
            m.put(length, (tempHead)); // tempHead is subclass of Object base class. Why error?
            tempHead = tempHead.next;
            length++;
        }
        int middle = (length / 2) + 1;
        int tempCount = 1;
        return m.get(middle);

    }
}





