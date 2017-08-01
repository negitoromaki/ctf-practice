public class ctfNOAH{
	int key = 1471587914;
	int lowkey = 1472541258;
	public static void main(String[] args){
		int res=0;





		int[] bytes = new int[6];
		for (int a = 32; a <= 126; a++) {
		   for (int b = 32; b <= 126; b++) {
		       for (int c = 32; c <= 126; c++) {
		          for (int d = 32; d <= 126; d++) {
		            for (int e = 32; e <= 126; e++) {
		               for (int f = 32; f <= 126; f++) {
		                  double test = a*Math.pow(31, 5) + b * Math.pow(31,4) + c * Math.pow(31, 3) + d * Math.pow(31, 2) + e * Math.pow(31, 1) + f;
		                  if(test == key || test == lowkey){
		                  	bytes[0] = a;
		                  	bytes[1] = b;
		                  	bytes[2] = c;
		                  	bytes[3] = d;
		                  	bytes[4] = e;
		                  	bytes[5] = f;
		                  }
		               }
		            }
		         }
		       }
		    }
		}
		for(int i = 0; i < bytes.length; i++){
			System.out.println(bytes[i]);
		}
	}

	private void rescursiveFind(int counter, int digit){
		if(result == key || lowkey){
			System.out.println(digit);
		}else{
			if(counter == 0){

			}else{

			}
		}
	}
	
}