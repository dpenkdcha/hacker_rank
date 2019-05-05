import java.util.Arrays;

class program7 {

    public static void main(String[] args) {
        System.out.println("Hello");

        long mno = 78961987000L;
        String s = Long.toString(mno);
        char[] c = s.toCharArray();  

        for(int i=0; i<s.length()-2; i++) {
            if(s.substring(i,i+1).equals(s.substring(i+1,i+2))) {
                if(s.substring(i+1,i+2).equals(s.substring(i+2,i+3))) {
                    System.out.println("Fancy for same 3 in seq" + i);
                    break;
                }
            }

            if(c[i] == c[i+1]+1 && c[i+1] == c[i+2]+1) {
                System.out.println("Fancy for decr" + i);
                break;
            } else if(c[i] == c[i+1]-1 && c[i+1] == c[i+2]-1) {
                System.out.println("Fancy for incr" + i);
                break;
            }
        }

        while (s.length() > 0) {
            String s1 = s.substring(0,1);
            int lb = s.length();
            s = s.replaceAll(s1, "");
            int la = s.length();
            if(lb >= la+4) {
                System.out.println("Fancy for same 4");
                break;
            }
        }
    }
}