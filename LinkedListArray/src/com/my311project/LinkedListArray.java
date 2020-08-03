package com.my311project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LinkedListArray<T extends Comparable<T>>{
    private Node<T> head, tail;
    private int keyoption;
    private int sizeoflinkedlist;
    private HashMap<Integer, Node<T>> map;
    private HashSet<Node<T>> set;
    private ArrayList<Integer> linkedarraylist;
    private int arrayfirstposition;

    public LinkedListArray(){
        head=new Node<T>();
        tail=new Node<T>();
        head.setNext(tail);
        tail.setPrev(head);
        keyoption = sizeoflinkedlist = arrayfirstposition = 0;
        linkedarraylist= new ArrayList<>();
        map=new HashMap<>();
        set=new HashSet<>();
    }

    public boolean isEmpty(){
        if(head.getNext().equals(tail))
            return true;
        return false;
    }


    public boolean contains(Node<T> x){
        if(set.contains(x))
            return true;
        return false;
    }


    public void insert(T data){
        Node<T> newnode = new Node<T>(data);
        newnode.setPrev(tail.getPrev());
        tail.getPrev().setNext(newnode);
        newnode.setNext(tail);
        tail.setPrev(newnode);
        map.put(keyoption, newnode);
        set.add(newnode);
        linkedarraylist.add(keyoption);
        keyoption++;
        sizeoflinkedlist++;
    }


    public void insertHead(T data){
        Node<T> newnode = new Node<T>(data);
        newnode.setPrev(head);
        newnode.setNext(head.getNext());
        head.getNext().setPrev(newnode);
        head.setNext(newnode);
        map.put(keyoption, newnode);
        set.add(newnode);
        linkedarraylist.add(arrayfirstposition, keyoption);
        keyoption++;
        sizeoflinkedlist++;
    }


    public void addBefore(T data, Node<T> x){
        if(contains(x)==true){
            Node<T> newnode = new Node<T>(data);
            x.getPrev().setNext(newnode);
            newnode.setPrev(x.getPrev());
            newnode.setNext(x);
            x.setPrev(newnode);
            map.put(keyoption, newnode);
            set.add(newnode);
            for(int i = arrayfirstposition ;i<linkedarraylist.size();i++){
                Node<T> tempnode = map.get(linkedarraylist.get(i));
                if(tempnode.equals(x)){
                    linkedarraylist.add(i,keyoption);
                    keyoption++;
                    sizeoflinkedlist++;}}
        }
        else throw new IllegalArgumentException("node does not exist");
    }

    public void addAfter(T data, Node<T> x){
        if(contains(x)==true){
            Node<T> newnode = new Node<T>(data);
            x.getNext().setPrev(newnode);
            newnode.setNext(x.getNext());
            newnode.setPrev(x);
            x.setNext(newnode);
            map.put(keyoption, newnode);
            set.add(newnode);
            for(int i = arrayfirstposition ;i<linkedarraylist.size();i++){
                Node<T> tempnode= map.get(linkedarraylist.get(i));
                if(tempnode.equals(x)){
                    linkedarraylist.add(i+1,keyoption);
                    keyoption++;
                    sizeoflinkedlist++;}}
        }
        else throw new IllegalArgumentException("node does not exist");
    }

    public void removefirst(){
        if(isEmpty()!=true){
            Node<T> temp = head.getNext();
            head.setNext(temp.getNext());
            temp.getNext().setPrev(head);
            map.remove(linkedarraylist.get(arrayfirstposition));
            set.remove(temp);
            sizeoflinkedlist--;
            arrayfirstposition++;
        }
        else throw new IllegalStateException("List is empty");
    }

    public void removelast(){
        if(isEmpty()!=true){
            Node<T> temp = tail.getPrev();
            temp.getPrev().setNext(tail);
            tail.setPrev(temp.getPrev());
            linkedarraylist.remove(linkedarraylist.size()-1);
            map.remove(linkedarraylist.get(linkedarraylist.size()-1));
            set.remove(temp);
            sizeoflinkedlist--;
        }
        else throw new IllegalStateException("List is empty");
    }

    public boolean remove(int position){
        if(position-1+arrayfirstposition<linkedarraylist.size() && position > 0 ){
            Node<T> temp = map.get(linkedarraylist.get(position-1+arrayfirstposition));
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            map.remove(linkedarraylist.get(position-1+arrayfirstposition));
            set.remove(temp);
            sizeoflinkedlist--;
            linkedarraylist.remove(position-1+arrayfirstposition);
            return true;

        }
        System.out.println("cant remove, position out of bounds");
        return false;
    }

    public boolean remove(Node<T> x){
        if(contains(x)==true){
            for(int i = arrayfirstposition;i<linkedarraylist.size();i++){
                if(x.equals(map.get(linkedarraylist.get(i)))){
                    map.remove(linkedarraylist.get(i));
                    set.remove(x);
                    linkedarraylist.remove(i);
                    x.getPrev().setNext(x.getNext());
                    x.getNext().setPrev(x.getPrev());
                    sizeoflinkedlist--;
                    }}
            return true;}
        System.out.println("Node does not exist");
        return false;
    }

    public void sort(){
        for(int i = arrayfirstposition+1; i < linkedarraylist.size(); i++) {
            for(int j = i; j > arrayfirstposition; j--){
                Node<T> temp1 = map.get(linkedarraylist.get(j));
                Node<T> temp2 = map.get(linkedarraylist.get(j-1));
                int m = temp1.getData().compareTo(temp2.getData());
                if(m<0){
                    temp2.getPrev().setNext(temp1);
                    temp1.setPrev(temp2.getPrev());
                    temp1.getNext().setPrev(temp2);
                    temp2.setNext(temp1.getNext());
                    temp1.setNext(temp2);
                    temp2.setPrev(temp1);

                    int a = linkedarraylist.get(j);
                    int b = linkedarraylist.get(j-1);
                    linkedarraylist.set(j-1, a);
                    linkedarraylist.set(j,b);


                }
            }

    }}

    public T get(int position){
        if(position-1+arrayfirstposition<linkedarraylist.size()&& position >0 ){
            return map.get(linkedarraylist.get(position-1+arrayfirstposition)).getData();
        }
        else throw new IndexOutOfBoundsException("Position is out of bounds");
    }
}





