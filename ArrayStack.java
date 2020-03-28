/**
* Array Stack
* @author Eli Gruzman
* 
*/

import java.util.*;
import java.io.*;

public class ArrayStack<T> implements Stack<T>
{
	protected T[] arr;
	protected int top;

	public ArrayStack()
	{
		arr = (T[])new Object[10];
		top = 0;
	}

	public void push(T item)
	{
		if (top == arr.length)
			growArray();
		arr[top++] = item;
	}

	public T pop() throws Exception
	{
		if (top == 0)
			throw new Exception("Stack empty");
		T next = arr[top-1];
		top--;
		return next;
	}

	public T peek() throws Exception
	{
		if (top == 0)
			throw new Exception("Stack empty");
		return arr[top-1];
	}

	public boolean empty()
	{
		return top == 0;
	}

	public void growArray()
	{
		T[] copy = (T[]) new Object[arr.length*2];
    	for (int i = 0; i < top; i++)
        	copy[i] = arr[i];
    	arr = copy;
	}
}