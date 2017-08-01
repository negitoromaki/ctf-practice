import java.io.PrintWriter;


public class ctfNOAH{
  private static int counter = 1;
  
  private static class CalculationThread1 extends Thread {
    public void run() {
      System.out.println("Creating thread1");
      calculate(32,56);
      System.out.println("Ending thread1");
    }
  }
  
  private static class CalculationThread2 extends Thread {
    public void run() {
      System.out.println("Creating thread2");
      calculate(57,80);
      System.out.println("Ending thread2");
    }
  }
  
  private static class CalculationThread3 extends Thread {
    public void run() {
      System.out.println("Creating thread3");
      calculate(81,104);
      System.out.println("Ending thread3");
    }
  }
  
  private static class CalculationThread4 extends Thread {
    public void run() {
      System.out.println("Creating thread4");
      calculate(105,126);
      System.out.println("Ending thread4");
    }
  }
  
  public static void calculate(int first, int last){
    
    // The given key
    int key = 1471587914;
    // The given lowercase key
    int lowkey = 1472541258;
    // Stores the bytes when found
    int[] bytes = new int[6];
    char[] chars = new char[6];
    
    // Loop through all possible combinations.
    for (int a = 32; a <= 126; a++) {
      for (int b = 32; b <= 126; b++) {
        for (int c = 32; c <= 126; c++) {
          for (int d = 32; d <= 126; d++) {
            for (int e = 32; e <= 126; e++) {
              for (int f = first; f <= last; f++) {
                
                // Calculate the hash.
                int test = (int) (a*Math.pow(31, 5) + b * Math.pow(31,4) + c * Math.pow(31, 3) + d * Math.pow(31, 2) + e * Math.pow(31, 1) + f);
                
                String characters = "" + chars[0] + chars[1] + chars[2] + chars[3] + chars[4] + chars[5];
                int hash = characters.toLowerCase().hashCode();
                
                // Check if the hashes equate one another.
                if(test == key && hash == lowkey){
                  bytes[0] = a;
                  bytes[1] = b;
                  bytes[2] = c;
                  bytes[3] = d;
                  bytes[4] = e;
                  bytes[5] = f;
                  
                  chars[0] = (char) a;
                  chars[1] = (char) b;
                  chars[2] = (char) c;
                  chars[3] = (char) d;
                  chars[4] = (char) e;
                  chars[5] = (char) f;
                  
                  // This will print out the bytes of the flag.
                  System.out.println(counter + ". [" + chars[0] + "  " + chars[1] + "  " + chars[2] + "  " + chars[3] + "  " + chars[4] + "  " + chars[5] + "]");
                  
                  try {
                    PrintWriter out = new PrintWriter( "filename.txt" );
                    out.println( "[" + chars[0] + "  " + chars[1] + "  " + chars[2] + "  " + chars[3] + "  " + chars[4] + "  " + chars[5] + "]" );
                    out.close();
                  } catch(Exception ex) {
                    
                  }
                  
                  //counter++;
                }
                
                counter++;
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