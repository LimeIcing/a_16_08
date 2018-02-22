public class Main08 {

    public static void main(String[] args) {
        LinkedIntList08 a = new LinkedIntList08();
        a.add(2);
        a.add(1);
        a.add(4);
        a.add(3);
        //a.add(5);
        a.switchPairs();
        System.out.println(a);
    }
}
