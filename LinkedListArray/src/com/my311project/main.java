package com.my311project;

import com.my311project.LinkedListArray;

public class main {
    public static void main(String[] args) {
        LinkedListArray newll = new LinkedListArray();
        newll.insert(4);
        newll.insert(28);
        newll.insert(6);
 
        newll.sort();
        newll.insert(3);
        newll.sort();
      
        System.out.println(newll.get(1));
        System.out.println(newll.get(2));
        System.out.println(newll.get(3));
        System.out.println(newll.get(4));
        
    }
}
