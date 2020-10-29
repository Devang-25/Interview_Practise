package com.company;
public class FlattenMultiLevelDoublyLL {
    static class Node{
        int val;
        Node next;
        Node prev;
        Node child;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next,Node prev,Node child){
            this.val=val;
            this.next=next;
            this.prev=prev;
            this.child=child;
        }

    }

    private static Node flatten(Node head){
        if(head==null)
            return null;
        Node curr=head;
        while(curr!=null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }

            Node temp = curr.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = temp;
            }
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }


    public static void main(String[] args){
         Node head=new Node(1);
         Node curr=head;
         curr.next=new Node(2);
         curr.next.next=new Node(3);
        curr.next.next.next=new Node(4);
        curr.next.next.next.next=new Node(5);
        curr.next.next.next.next.next=new Node(6);
         curr.next.next.child=new Node(7);
         curr.next.next.child.next=new Node(8);
        curr.next.next.child.next.next=new Node(9);
        curr.next.next.child.next.next.next=new Node(10);
        curr.next.next.child.next.child=new Node(11);
        curr.next.next.child.next.child.next=new Node(12);

        Node result=flatten(head);
        Node dummy=result;

        while(dummy!=null){
            System.out.print(dummy.val+ " ");
            dummy=dummy.next;
        }

    }

}
