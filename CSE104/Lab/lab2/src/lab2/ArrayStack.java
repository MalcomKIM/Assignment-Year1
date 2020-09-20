/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.EmptyStackException;

/**
 *
 * @author minhao.jin17
 */

public class ArrayStack<E> implements Cloneable {

    private E[] data;
    private int manyItems;

    /**
     * Initialize an empty bag with an initial capacity of 10.
     *
     */
    public ArrayStack() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Initialize an empty bag with a specified initial capacity.
     *
     */
    public ArrayStack(int initialCapacity) {
        //students' implementation here.
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("The initialCapacity is negative: " + initialCapacity);
        }
        data = (E[]) new Object[initialCapacity];
        manyItems = 0;
    }

    /**
     * Add a new element to this bag. If the new element would take this bag
     * beyond its current capacity, then the capacity is increased before adding
     * the new element.
     *
     * @param element the new element that is being inserted
     *
     */
    public void add(E element) {
        if (manyItems == data.length) {  // Ensure twice as much space as we need.
            ensureCapacity((manyItems + 1) * 2);
        }
        data[manyItems] = element;
        manyItems++;
    }


    /**
     * Generate a copy of this bag.
     *
     * @return The return value is a copy of this bag. Subsequent changes to the
     * copy will not affect the original, nor vice versa.
     *
     */
    public ArrayStack<E> clone() {  // Clone an ArrayBag object.
        ArrayStack<E> answer;
        try {
            answer = (ArrayStack<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }
        answer.data = data.clone();
        return answer;
    }

  
    /**
     * Change the current capacity of this bag.
     *
     * @param minimumCapacity the new capacity for this bag
     *
     */
    public void ensureCapacity(int minimumCapacity) {
        E biggerArray[];
        if (data.length < minimumCapacity) {
            biggerArray = (E[]) new Object[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    /**
     * Accessor method to get the current capacity of this bag.
     *
     */
    public int getCapacity() {
        return data.length;
    }

    
    public boolean isEmpty(){
        return manyItems==0;
    }

    public E peek() throws EmptyStackException {
        return data[0];
    }
    
    public E pop() throws EmptyStackException{
        E res=data[0];
        for(int i=0;i<manyItems-1;i++){
            data[i]=data[i+1];
        }
        manyItems--;
        return res;
    }
    
    public void push(E e){
        ensureCapacity(manyItems+1);
        
        for(int i=manyItems;i>=1;i--){
            data[i]=data[i-1];
        }
        data[0]=e;
        manyItems++;
    }
    
 
    public int size() {
        return manyItems;
    }

    /**
     * Reduce the current capacity of this bag to its actual size (i.e., the
     * number of elements it contains).
     *
     */
    public void trimToSize() {
        E[] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = (E[]) new Object[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }

    public int remainedCapacity(){
        return data.length-manyItems;
    }


}

