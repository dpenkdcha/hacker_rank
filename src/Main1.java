import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello");
		
		letters ls = new letters("ABCD");
		
		for(Object t : ls.getThreads()) {
			System.out.println("Thread " + ((Thread)t).getName());
		}
		
		/*Thread ta = new Thread(ls, "A");
		ta.start();
		Thread tb = new Thread(ls, "B");
		tb.start();
		Thread tc = new Thread(ls, "C");
		tc.start();
		Thread td = new Thread(ls, "D");
		td.start();*/
		
		Thread.sleep(5000);
		
		System.out.println(ls.output());
		
		
		System.out.println("The program has finished running");
	}
}

class letters implements Runnable{
	
	String name = "";
	String orig = "";
	Thread T;
	String fn="";
	List<Thread> ls = new ArrayList<>();
	public letters(String string) {
		orig = string;
		
	}
	

	public Object[] getThreads() {
		
		int i=0;
		while (i < orig.length()) {
			name = orig.substring(i, i+1);
			fn = fn + name;
			T = new Thread(this, name);
			T.start();
			i++;
			ls.add(T);
		} 
		
		return ls.toArray();
	}

	
	public void run() {
		try {
			for(int i=0;i<orig.length();i++) {
				System.out.println("Hi" + name);
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String output() {
		return fn;
	}
}
