interface Calc{
    int calculate(int a, int b);
    default int test(){
        return 0;
    }

    static int test2(){
        return 0;
    }
}

public class LambdaExample {

    public static void main(String[] args) {

        Calc add = (a,b) -> {
           return a + b;
        };

        Calc subtract = (a,b) -> a-b;

       var result = add.calculate(10,20);

        System.out.println(result);

    }

}


