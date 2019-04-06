import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * This program uses a circular queue to match up partners for a dance
 */
public class AnnouncingDancingPartners {

	public static void main(String[] args) throws IOException {

		String dancer;
		CQueue<String> mqueue = new CQueue<String>();
		CQueue<String> fqueue = new CQueue<String>();
		
		Scanner infile = new Scanner( new File( "dancers.txt"));
		
		while( infile.hasNextLine()) {
			dancer = infile.nextLine();
			if (dancer.charAt(0) == 'F')
				fqueue.enqueue(dancer.substring(2));
			else if (dancer.charAt(0) == 'M')
				mqueue.enqueue(dancer.substring(2));
			else
				System.out.println("This dancer's name isn't formatted correctly.");
		}
		
		System.out.println( "Announcing Dancers: " + fqueue);
		System.out.println( "Announcing Dancers: " + mqueue);
		
		System.out.println("\nThe dancer partners are: ");
		
		while(!mqueue.isEmpty() && !fqueue.isEmpty()) {
			System.out.println(mqueue.dequeue() + " and " + fqueue.dequeue());
		}
		
		if(!mqueue.isEmpty() || !fqueue.isEmpty()) {
			System.out.println("\nThe following dancers do not have partners:");
			while(!mqueue.isEmpty())
				System.out.println(mqueue.dequeue());
			while(!fqueue.isEmpty())
				System.out.println(fqueue.dequeue());
		}
		
		infile.close();
		return;
	}
}