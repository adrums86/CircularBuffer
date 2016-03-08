/**
 * This class represents a circular buffer/queue data structure. This is a very basic
 * solution, being it is my first attempt at a circular buffer. In practice it seems it would 
 * be far more beneficial to use an implementation from the Java API rather than creating a
 * new class to represent the buffer.
 * @author Adam Waldron
 * @version 1.0
 */
public class CircularBuffer {
	
	/**
	 * Default buffer size.
	 */
	private static int DEFAULT_SIZE = 10;
	
	/**
	 * The stored value of the buffer size.
	 */
	private int myMaxSize;
	
	/**
	 * The current size of the buffer.
	 */
	private int myCurrentSize;
	
	/**
	 * The current starting/reading index of the buffer.
	 */
	private int myStart;
	
	/**
	 * The current end/writing index of the buffer.
	 */
	private int myEnd;
	
	/**
	 * The buffer array.
	 */
	private char[] myBuffer; 
	
	/**
	 * Default constructor that sets the max size of the buffer to 10.
	 */
	public CircularBuffer() {
		myMaxSize = DEFAULT_SIZE;
		myBuffer = new char[myMaxSize];
		myStart = 0;
		myEnd = 0;
		myCurrentSize = 0;
	}
	
	/**
	 * Constructor for setting the queue size.
	 * @param theSize passes the size to mySize.
	 */
	public CircularBuffer(final int theSize) {
		myMaxSize = theSize;
		myBuffer = new char[myMaxSize];
		myStart = 0;
		myEnd = 0;
		myCurrentSize = 0;
	}
	
	/**
	 * Inserts a char value into the buffer at the current end point.
	 * if the buffer is full, meaning the current size equals the max size, the
	 * buffer will write over the oldest written data in the buffer.
	 * @param theChar
	 */
	public void insert(final char theChar) {
		myEnd = (myEnd + 1) % myMaxSize;
		myBuffer[myEnd] = theChar;
		if (myCurrentSize == myMaxSize) {
			myStart = (myStart + 1) % myMaxSize;
		} else {
			myCurrentSize ++;
		}
	}
	
	/**
	 * Removes the value at the starting point of the buffer and returns
	 * the value. If the buffer is empty it returns '!' and prints a err
	 * to the console.
	 * @return the value to be removed or '!' if the buffer is empty.
	 */
	public char remove() {
		if (myCurrentSize == 0) {
			System.err.println("The buffer is empty!");
			return '!';
		} else {
			myStart = (myStart + 1) % myMaxSize;
			myCurrentSize --;
			return myBuffer[myStart];		
		}
	}
	
	
}
