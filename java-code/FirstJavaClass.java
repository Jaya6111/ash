public class FirstJavaClass {
    public static void main(String[] args) {
        //**3**
        //*323*
        //32123
        //*323*
        //**3**
        for(int i=5; i > 0; i--) {
            for( int j=i-1; j>0; j--) {
                System.out.print("*");
            }
            for(int j=i; j<=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

    }
}
