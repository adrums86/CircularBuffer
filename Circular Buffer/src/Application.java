
public class Application {

	public static void main(String args[]) {
		CircularBuffer buffer = new CircularBuffer(4);
		buffer.insert('A');
		buffer.insert('B');
		buffer.insert('C');
		buffer.insert('D'); //Buffer is now full.
		
		//Writes over A.
		buffer.insert('E');
		buffer.insert('F');
		buffer.insert('G');
		buffer.insert('H'); //Wraps a second time.
		
		//Writes over E.
		buffer.insert('I');
		System.out.println(buffer.remove());	
	}
}
