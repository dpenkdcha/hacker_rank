class Program11 {
    public static void main(String[] args) {
        System.out.println("Hello");

        int m = 1;
        int a[] = new int[]{1, 1, 1, 1, 1, 0, 0, 1, 1, 1};
        int wr=0, wl=0, li=0, w = 0, zc=0;
        while(wr < a.length) {
            System.out.println("1 wr : " + wr + " wl : " + wl + " li : " + li + " w : " + w + " zc : " + zc);
            if(zc <= m) {
                if(a[wr] == 0) {
                    zc++;
                }
                wr++;
            }
            System.out.println("2 wr : " + wr + " wl : " + wl + " li : " + li + " w : " + w + " zc : " + zc);
            if(zc > m) {
                if(a[wl] == 0) {
                    zc--;
                }
                wl++;
            }
            System.out.println("3 wr : " + wr + " wl : " + wl + " li : " + li + " w : " + w + " zc : " + zc);
            if((wr-wl > w) && zc <= m) {
                w = wr - wl;
                li = wl;
            }
            System.out.println("4 wr : " + wr + " wl : " + wl + " li : " + li + " w : " + w + " zc : " + zc);
            System.out.println("");
        }

        for(int i =0;i<w;i++) {
            if(a[li+i] == 0) {
                System.out.println("Index : " + (li+i));
            }
        }
    }    
}