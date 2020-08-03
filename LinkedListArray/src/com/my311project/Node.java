package com.my311project;

import com.my311project.Node;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> prev, next;

    public Node(T data){
        this.data = data;
        prev = next = null;
    }

    public Node(){
        data = null;
        prev = next = null;
    }

    public void setNext(Node x){

        next = x;
    }
    public void setPrev(Node x){

        prev = x;
    }
    public Node getNext(){

        return next;
    }
    public Node getPrev(){

        return prev;
    }
    public T getData(){
        return data;
    }



}
