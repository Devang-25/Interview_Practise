package com.company;



public class Main {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(){

        }
        public ListNode(int val){
            this.val=val;
        }
        public ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode sentinel=new ListNode(0);
        sentinel.next=head;
        ListNode curr=head,prev=sentinel;

        while(curr!=null){
            if(curr.val==val){
                prev.next=curr.next;
            }
            else{
                prev=curr;
            }
            curr=curr.next;
        }

        return sentinel.next;
    }

    public static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
	// write your code here
    //[1,2,6,3,4,5,6]
        ListNode head=new ListNode(1);
        ListNode curr=head;
        curr.next=new ListNode(2);
        curr.next.next=new ListNode(6);
        curr.next.next.next=new ListNode(3);
        curr.next.next.next.next=new ListNode(4);
        curr.next.next.next.next.next=new ListNode(5);
        curr.next.next.next.next.next.next=new ListNode(6);
        System.out.println("******Before Deletion*********");
        printList(head);

        System.out.println();
        System.out.println("******After Deletion*********");
        ListNode result = removeElements(head,6);
        printList(result);
    }
}


