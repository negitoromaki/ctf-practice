public class ctfNOAH{
  
  private static class CalculationThread1 extends Thread {
    public void run() {
      System.out.println("Creating thread1");
      calculate(32,56);
    }
  }
  
  private static class CalculationThread2 extends Thread {
    public void run() {
      System.out.println("Creating thread2");
      calculate(57,80);
    }
  }
  
  private static class CalculationThread3 extends Thread {
    public void run() {
      System.out.println("Creating thread3");
      calculate(81,104);
    }
  }
  
  private static class CalculationThread4 extends Thread {
    public void run() {
      System.out.println("Creating thread4");
      calculate(105,126);
    }
  }
  
  public static void calculate(int first, int last){
    
    // The given key
    int key = 1471587914;
    // The given lowercase key
    int lowkey = 1472541258;
    // Stores the bytes when found
    int[] bytes = new int[6];
    
    // Loop through all possible combinations.
    for (int a = 32; a <= 126; a++) {
      for (int b = 32; b <= 126; b++) {
        for (int c = 32; c <= 126; c++) {
          for (int d = 32; d <= 126; d++) {
            for (int e = 32; e <= 126; e++) {
              for (int f = first; f <= last; f++) {
                
                // Calculate the hash.
                double test = a*Math.pow(31, 5) + b * Math.pow(31,4) + c * Math.pow(31, 3) + d * Math.pow(31, 2) + e * Math.pow(31, 1) + f;
                
                // Check if the hashes equate one another.
                if(test == key || test == lowkey){
                  bytes[0] = a;
                  bytes[1] = b;
                  bytes[2] = c;
                  bytes[3] = d;
                  bytes[4] = e;
                  bytes[5] = f;
                  
                  // This will print out the bytes of the flag.
                  for(int i = 0; i < bytes.length; i++){
                    System.out.println(bytes[i]);
                  }
                  
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void run() {
    Thread calculate1, calculate2, calculate3, calculate4;
    // run thread
    calculate1 = new Thread(new ctfNOAH.CalculationThread1());
    calculate1.start();
    
    calculate2 = new Thread(new ctfNOAH.CalculationThread2());
    calculate2.start();
    
    calculate3 = new Thread(new ctfNOAH.CalculationThread3());
    calculate3.start();
    
    calculate4 = new Thread(new ctfNOAH.CalculationThread4());
    calculate4.start();
    
  }
  
  public static void main(String[] args){
    run();
  }
}