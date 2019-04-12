import java.util.*;
public class Main
{
    
    public static void game(int n){
        
        boolean p1 = true;
        boolean p2 = false;
        
        while(n>1){
            
            if(p1) {
            
            if(n>=5) {n = n-5; p2 = true;} 
            else if(n>=3) {n = n-3; p2 = true;}
            else if(n>=2){n = n-2; p2 = true;}
            else { System.out.println("Player 1 Won"); }
            
            }
            
            if(p2) {
            
            if(n>=5) {n = n-5; p1 = true;} 
            else if(n>=3) {n = n-3; p1 = true;}
            else if(n>=2) {n = n-2; p1 = true;}
            else { System.out.println("Player 1 Won"); }
            }
        }
        
        if(p1) System.out.println("Player 1 Won");
        else System.out.println("Player 2 Won");
    }
    
public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    game(m);

}
} 
