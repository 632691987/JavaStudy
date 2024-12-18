package jdk21;

public class RecordStudy {

    public static void main(String[] args) {
        Point point = new Point(2, 3);

        if (point instanceof Point(int m, int n)) {
            System.out.println(m + n);
        }

        if (point instanceof Point(_, int n)) {
            System.out.println(STR."I don't need to use the variable which I don't need, only n=\{n} here is enough!");
        }
    }

}
