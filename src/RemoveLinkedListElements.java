public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }


    public static class ListNode {
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


        public static ListNode removeElements(ListNode head, int val) {
            var temp = head;

            //adjust the head if needed.
            while (temp != null && temp.val == val) {
                head = temp.next;
                temp = head;
            }

            var previous = head;
            while (temp != null) {
                if (temp.val == val)
                    previous.next = temp.next;
                else
                    previous = temp;

                temp = temp.next;
            }
            return head;
        }
    }
}
