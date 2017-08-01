import Java.util.ArrayLists;
public class ctfNOAH{
	int key = 1471587914;
	int lowkey = 1472541258;
	int res = 0;
	public static void main(String[] args){
		int res=0;
		ArrayList<int> list = new ArrayList<int>();
		try{
			rescursiveFind(key, 5);
		}catch(StackOverFlowError e){
			e.printStackTrace();
		}

		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

	private void rescursiveFind(int rem_val, int counter){
		if(rem_val >= 32 && rem_val <= 126){ 
			System.out.println(rem_val);
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
				list.clear();
			}
		}
	}
	
}