package com.deepster.linkedList;

public class Main {


    public static void main(String[] args) {

        Node merge = new Node(10);
        merge.add(new Node(11))
                .add(new Node(12));
        
        
        Node max = new Node(8);
        max.add(new Node(9))
                .add(merge);
        
        Node min = new Node(7);
        min.add(merge);

        Node singleNode = new Node(2);
        Node singleNode2 = new Node(3);


        Node.findMergePoint(max, min);





    }
}
