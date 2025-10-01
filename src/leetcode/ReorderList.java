package leetcode;

public class ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;       // slow는 한칸씩 가서 중간 도달
            fast = fast.next.next;  // fast는 두칸씩 가서 끝 도달
        }
        ListNode mid = slow;        // 중간위치를 찾음

        ListNode curr = mid.next;   // 뒤집기 시작
        mid.next = null;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = head;       // 합치기
        ListNode right = prev;
        ListNode nextLeft, nextRight;

        while (left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
