
class Program{

    static int count;
    void showCount(){
        System.out.println(count);
    }
}

public class StaticExample {

    public static void main(String[] args) {

        Program p1 = new Program();
        Program p2 = new Program();
        p1.count=1;

        p2.count=2;

        p1.showCount();
        p2.showCount();

    }

}
