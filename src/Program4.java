public class Program4 {
    public static void main(String[] args) {
        int n = 5;
        int[][] a = new int[n][n];
        
        a[0][0] = 1;    
        a[1][1] = 1;
        a[2][2] = 1;
        a[3][3] = 1; 
        a[4][4] = 1;

        a[0][4] = 1;
        a[1][3] = 0;
        a[2][2] = 1;
        a[3][1] = 1;
        a[4][0] = 1;

        a[2][4] = 1;
        a[2][3] = 1;
        a[2][2] = 1;
        a[2][1] = 1;
        a[2][0] = 1;

        a[0][4] = 1;
        a[1][4] = 1;
        a[2][4] = 1;
        a[3][4] = 1;
        a[4][4] = 1;


        boolean r=false,c=false;
        int d1=0,d2=0;

        for(int i=0;i<n;i++) {
            if(a[0][i] == 1) {
                for(int k=0;k<n;k++) {
                    if (a[k][i] == 1) {
                        c = true;
                    } else {
                        c = false;
                        break;
                    }
                }
                if(c==true) {
                    System.out.println("Col : " + i);
                    c = false;
                }
            }
            if(a[i][0] == 1) {
                for(int k=0;k<n;k++) {
                    if (a[i][k] == 1) {
                        r = true;
                    } else {
                        r = false;
                        break;
                    }
                }
                if(r==true) {
                    System.out.println("Row : " + i);
                    r = false;
                }  
            }
            if(a[i][i] == 1) {
                d1 = d1 + a[i][i];
            }
            if(a[i][n-i-1] == 1) {
                d2 = d2 + a[i][n-i-1];
            }
        }
        String x = "";
        if(d1 == n) {
            x = "D1 has all 1"; 
        }

        if(d2 == n) {
            x = x + " D2 has all 1";
        }
        System.out.println(x);
    }
}