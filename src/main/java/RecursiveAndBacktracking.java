public class RecursiveAndBacktracking {
    static int a = 5;
    static int b = 4;

    public static void main(String[] args) {
        writeSquares(5);
        //System.out.println(Math.round((double)7/2));
    }

    public static int Recursive(int index){
        if (index == 1) return a;
        else {
            return Recursive(index) + Recursive(index -1);
        }
    }

    public static String starString(int n){
        if (n<0) {
            throw new IllegalArgumentException();
        } else
        if (n==0){
            return "*";
        }
        {
            return starString(n-1) + starString(n-1);
        }
    }

    public static void writeNums(int n){
        if (n<1){
            throw new IllegalArgumentException();
        } else {
            if (n==1) {
                System.out.print(n);
            } else {
                writeNums(n-1);
                System.out.print(", "+ n);
            }
        }
    }

//    public static void writeSequence(int n){
//        if (n <1){
//            throw new IllegalArgumentException();
//        } else {
//            if (n == 1) {
//                System.out.println(n);
//            }
//        }
//    }

    public static void writeSequence(int n) {
        if (n<1){
            throw new IllegalArgumentException();
        } if (n == 1){
            System.out.print(n);
        }
        else
        if (n % 2 == 0){
            System.out.print(n/2 + " ");
            writeSequence(n-1);
            System.out.print(" "+n/2);
        } else {
            System.out.print((n/2)+1 + " ");
            writeSequence((n-1));
            System.out.print(" "+(n/2)+1);
        }
    }

    public static void writeSquares(int n){
        if (n<1 ){
            throw new IllegalArgumentException();
        } else if (n==1) {
            System.out.print(n);
        }
        else {
           if (n % 2 == 0) {
               System.out.print((n-1)*(n-1)+ ", ");

                   if (n-2 > 0){
                       writeSquares(n-2);
                       System.out.print(", "+n*n);
                   } else {
                       System.out.print(n*n);
                   }


           } else {
               System.out.print(n*n+ ", ");
               writeSquares(n-2);
               System.out.print(", "+ (n-1)*(n-1));
           }
        }
    }
}
