import java.util.ArrayList;
import java.lang.StackOverflowError;

public class ctfNOAH{
	static int key = 1471587914;
	static int lowkey = 1472541258;
	static int res = 0;
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args){
		try{
			rescursiveFind(key, 5);
		}catch(StackOverflowError e){
			e.printStackTrace();
		}

		if(list.size() == 0){
			System.out.println("NONE FOUND");
		}
	}

	private static void rescursiveFind(int rem_val, int counter){
		if(rem_val >= 32 && rem_val <= 126){ 
			System.out.println("done");
		}else{
			if(counter > 0){
				for(int i = 32; i <= 126; i++){
					double new_val = (rem_val - i) / 31;
					if((rem_val % 1) > 0){ //if rem_val is decimal
						break; //failed, then ded and break out of for loop
					}else{
						list.add(i);
						rescursiveFind(rem_val, counter - 1); //keep going
					}
				}
			}else{
				if(list.size() > 1){
					//printList(list);
					list.clear();
					//System.out.println("Failed");
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