package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method

        head=null;
        tail=null;
        size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method

        //first we check if the element is empty
        if (element == null) {
            throw new NullPointerException();
        }

        //creat a new node using the element as data
        LLNode<E> node = new LLNode<E>(element);

        //if the linklist is empty
        if(head==null){
            head = node;
            tail = node;
            size++;
        }

        //linkedlist not empty add the element at the end of linkedlist
        else {
            LLNode<E> lastNode = head;  //start from head
            while (lastNode.next != null){  // go till the end of the linkedlist
                lastNode = lastNode.next;
            }
            lastNode.next = node; //put the new node at the end of the list
            node.prev = lastNode;
            tail = node;
            size++;
        }
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.

        if ( index < 0  || index >= size){
            throw new IndexOutOfBoundsException();
        }

        LLNode<E> current = head; //point the curren to be the starting of the list
        for (int i = 0; i < index ; i++) {
            current = current.next; //iterate till the index
        }
        return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		// TODO: Implement this method
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(element == null){
            throw new NullPointerException();
        }

        LLNode<E> current = head; //point the curren to be the starting of the list
        LLNode<E> node = new LLNode<E>(element);

        for (int i = 0; i < index ; i++) {
            current = current.next; //iterate till the index
        }

        if (head == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        if(index==0){
            head = node;
        }
        if(index == size-1){
            tail = current;
        }
        node.next=current;
        node.prev=current.prev;
        if(current.prev!=null){ //because of the 0 index we have to check this
            current.prev.next=node;
        }
        current.prev=node;

        size++;
	}

	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null){
            throw new NullPointerException();
        }

        LLNode<E> current = head; //point the curren to be the starting of the list

        for (int i = 0; i < index ; i++) {
            current = current.next;
        }
        if (current.prev == null){
            head = current.next;
        }
        else {
            current.prev.next = current.next;
        }
        if (current.next == null){
            tail =current.prev;
        }
        else {
            current.next.prev = current.prev;
        }
        size--;
        return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
        // TODO: Implement this method

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }

        LLNode<E> current = head; //point the curren to be the starting of the list
        LLNode<E> node = new LLNode<E>(element);

        for (int i = 0; i < index; i++) {
            current = current.next; //iterate till the index
        }
        E oldData = current.data;
        current.data = element;
        return oldData;
    }

    public String toString(){
        String s="";
        LLNode<E> ptr = head;
        while(ptr!=null){
            s=s+"-"+ptr.data;
            ptr=ptr.next;
        }
        return s;
    }

}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
