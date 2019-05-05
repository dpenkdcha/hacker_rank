class Program9 {
    public static void main(String[] args) {
        System.out.println("Hello");

        int[] a = {100, 180, 260, 310, 40, 30, 535, 695, 345, 55, 33, 310, 975, 456, 45, 5};
        int buy;
        int sell = 0;
        for(int i=0;i<a.length-1;i++) {
            if(a[i] <= a[i+1]) {
                buy = a[i];
                System.out.println("Buy at : " + buy + " on day : " + i);
                for(int k = i;k<a.length-1;k++) {
                    if(a[k] >= a[k+1]) {
                        sell = a[k];
                        i = k;
                        System.out.println("Sell at : " + sell + " on day : " + i);
                        break;
                    } else if( k == a.length-2) {
                        sell = a[k+1];
                        i = k+1;
                        System.out.println("Sell at : " + sell + " on day : " + i);
                    }
                }
            }
        }
    }
}