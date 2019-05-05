class Program10 {
    public static void main(String[] args) {
        System.out.println("Hello");

        int a = 123211;
        int r=0;
        int temp = 0;
        int i = a;
        while(a > 0) {
            temp = a % 10;
            r = r*10 + temp;
            a = a / 10;
        }
        if(i==r){
            System.out.println("Pelindrom");
        }
        System.out.println("Reverse: " + r);
    }
}