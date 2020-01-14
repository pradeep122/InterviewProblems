package com.deepster.linkedList;

public class Node {
    private int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node add(Node node){
        this.next = node;
        return node;
    }

    public static int size(Node list){
        if(list == null){
            return  0;
        }
        int size = 1;
        while(list.next != null){
            size ++;
            list = list.next;
        }
        return size;
    }

    public static Node findMergePoint(Node list1, Node list2){

        Node max, min = null;

        if (Node.size(list1) > Node.size(list2)) {
            max = list1;
            min = list2;

        } else {
            max = list2;
            min = list1;
        }

        int diff = Math.abs(Node.size(list1) - Node.size(list2));

        for (int i = 0; i < diff; i++) {
            max = max.next;
        }

        while(max != min && max.next != null && min.next != null){
            max = max.next;
            min = min.next;
        }
        if(max != min){
            max = null;
        }

        // pinting
        System.out.println("  MAX  ");
        Node.printList(list1);
        System.out.println("  MIN  ");
        Node.printList(list2);
        System.out.println("mergePoint = " + max);

        return max;
    }

    public static void printList(Node list){
        System.out.print("[ ");
        while(list != null){
            System.out.print(list);
            System.out.print(", ");
            list = list.next;
        }
        System.out.println(" ]");
    }


    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
