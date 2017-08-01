import java.util.ArrayList;
import java.lang.StackOverflowError;

public class ctfNOAH{
	static int key = 1471587914;
	static int lowkey = 1472541258;
	static int res = 0;

	static class searchThread extends Thread{
		int highLim;
		int lowLim;	
		ArrayList<Integer> digitList = new ArrayList<Integer>();

		searchThread(int x, int y){
			lowLim = x;
			highLim = y;
		}
		public void run(){
			rescursiveFind(key, 6, highLim, lowLim, digitList);
			if(digitList.size() == 0){
				System.out.println("Range " + lowLim + " to " + highLim + " has failed");
			}
		}
	}

	public static void main(String[] args){
		try{
			Thread t1, t2, t3, t4;
			t1 = new searchThread(32, 69);
			t2 = new searchThread(70, 126);
			t1.start();
			t2.start();
		}catch(StackOverflowError e){
			e.printStackTrace();
		}
	}

	private static void rescursiveFind(int rem_val, int counter, int high, int low, ArrayList<Integer> list){
		if(rem_val >= high && rem_val <= low){ 
			System.out.println("done");
		}else{
			if(counter > 0){
				if(counter != 6){ //only do the split values for the first character to find
					high = 126;
					low = 32;
				}
				for(int i = low; i <= high; i++){
					double new_val = (rem_val - i) / 31;
					if((rem_val % 1) > 0){ //if rem_val is decimal
						break; //failed, then ded and break out of for loop, 
					}else{
						list.add(i);
						rescursiveFind(rem_val, counter - 1, high, low, list); //keep going
					}
				}
			}else{
				if(list.size() > 1){
					list.clear();
				}
			}
		}
	}

	private static void printList(ArrayList<Integer> l){
		String str = "";
		for(int i = 0; i < l.size(); i++){
			str += Integer.toString(l.get(i));
			str+= " ";
		}
		System.out.println(str);
	}
	
}