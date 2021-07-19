public class SecondHighest{

     public static void main(String []args){
        System.out.println("Hello World");
     
     
     int a[] =  {19,20,2,5,8,1,14,17,16};
     int b=0,c=0;
     
     for(int i=0;i<a.length-1;i++) {
         if(a[i] > a[i+1] && b < a[i]) {
             b = a[i];
         }
     }
     System.out.println(b);
     
     for(int i=0;i<a.length;i++) {
         if(a[i] == b){
             a[i]=0;
         }
     }
     
     for(int i=0;i<a.length-1;i++) {
         if(a[i] > a[i+1] && c < a[i]) {
             c = a[i];
         }
     }
     
     System.out.println(c);
     }
     
}