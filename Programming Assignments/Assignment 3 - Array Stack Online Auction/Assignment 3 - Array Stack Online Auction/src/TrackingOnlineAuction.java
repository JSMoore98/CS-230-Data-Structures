/**
 * This program utilizes an array stack data structure to keep track
 * of bidding history in an auction
 * - Josiah Moore
 */
import java.io.*;
import java.util.Scanner;

public class TrackingOnlineAuction {

	public static void main(String[] args) throws FileNotFoundException {
		
		int newBid=0,currentBid=0,maxBid=0;
		String highBidder="",newBidder="",result="";
		
		File file = new File("bids.txt");
		Scanner bidList = new Scanner(file);
		
		ABStack<Integer> bidStack = new ABStack<Integer>();
		ABStack<String> nameStack = new ABStack<String>();
		
		System.out.println("New Bid / Result / High Bidder / High Bid / Maximum Bid");
		System.out.println("=======================================================");
		
		while(bidList.hasNext()) {
			newBid = bidList.nextInt();
			newBidder = bidList.next();
			
			//If the new bid is the new highest
			if (newBid > maxBid) {
				currentBid = maxBid + 1;
				maxBid = newBid;
				highBidder = newBidder;
				result = "New high bidder";
				
				bidStack.push(currentBid);
				nameStack.push(highBidder);
			}
			//If the new bid is less than the max but enough to raise the minimum bet
			else if (newBid > currentBid && newBid < maxBid) {
				currentBid = newBid;
				result = "High bid increased";
				
				bidStack.push(currentBid);
				nameStack.push(highBidder);
			}
			//If the bid is less than both the current and maximum bets
			else {
				result = "No change";
			}
			
			System.out.println(newBid+" "+newBidder+" / "+result+" / "+highBidder+" / "+currentBid+" / "+maxBid);
			
		}
		
		System.out.println("\nThe bid history for this auction is:");
		
		while (!bidStack.isEmpty()) {
			System.out.println(nameStack.pop() + ": " + bidStack.pop());
		}
		
		bidList.close();

	}

}
