package com.company;

public class FIFO {
    Node head;

    class Node{
        Data data;
        Node next;
        Node(Data data){
            this.data = data;
        }
    }

    void push(Data data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
    }

    Data pull(){
        if(head == null)
            return null;
        Data toReturn = head.data;
        head = head.next;
        return toReturn;
    }

    int getHeadPriority(){
        if(this.head == null)
            return -1;
        return head.data.priority;
    }

    void print(){
        System.out.println();
        Node current = this.head;
        while(current != null){
            System.out.print(current.data.symbol);
            current = current.next;
        }

    }
}
