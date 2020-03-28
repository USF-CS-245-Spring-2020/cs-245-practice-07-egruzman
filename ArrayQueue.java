/**
* Array Queue
* @author Eli Gruzman
* 
*/

import java.util.*;
import java.io.*;

public class ArrayQueue<T> implements Queue<T>
{
	protected int front = 0;
	protected int back = 0;
	protected int size = 0;
	protected T[] arr;

	public ArrayQueue()
	{
		arr = (T[])new Object[10];
	}

	public T dequeue() throws Exception
	{
		if (size == 0)
			throw new Exception("Queue empty");

		T next = arr[front];
		size--;
		front++;
		if (front == arr.length)
			front = 0;
		return next;
	}

	public void enqueue(T item)
	{
		if (size == arr.length)
			growArray();
		arr[back++] = item;
		if (back == arr.length)
			back = 0;
		size++;
	}

	public boolean empty()
	{
		return size == 0;
	}

	public void growArray()
	{
        T[] copy = (T[]) new Object[arr.length*2];
    	for (int i = 0; i < size; i++)
        	copy[i] = arr[(front + i) % arr.length];
    	arr = copy;
    	front = 0;
    	back = size;
	}
}