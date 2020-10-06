package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddTwoNumbers {
	
	
	//Definition for singly-linked list.
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        
        ListNode firstLL = l1;
        ListNode secondLL = l2;
        ListNode current = dummy;
        int carry = 0;
        while(firstLL != null || secondLL != null){
            int x = (firstLL != null) ? firstLL.val : 0;
            int y = (secondLL != null) ? secondLL.val : 0;
            
            int sum = carry + x + y;
            
            carry = sum / 10;
            
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            if(secondLL != null) secondLL = secondLL.next;
            if(firstLL != null) firstLL = firstLL.next;
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
		
		List<Integer> printResult = new ArrayList<>();
		ListNode result = addTwoNumbers(l1, l2);
		
		while(result != null ){
			printResult.add(result.val);
			result = result.next;
		}
		System.out.println("[" +printResult.stream().map(s -> s.toString()).collect(Collectors.joining(",")) + "]");
	}
}
