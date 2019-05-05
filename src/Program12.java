import java.util.HashSet;

class Program12 {
    public static void main(String[] args) {
        System.out.println("Hello");

        int[] a = {1, 2, 2, 3, 4, 4, 4, 5, 5,4,3,5,2,5,1,6,70,3,5,6,4,71,4,6,9,6,3,72,8,9,7}; 
        HashSet<Integer>  hs = new HashSet<>();
        for(int i : a) {
            hs.add(i);
        }

        System.out.println("Array : " + hs.toString());
    }
}