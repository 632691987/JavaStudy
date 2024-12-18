package jdk21;

import java.util.List;

public class UnnameStudy {

    public void main() {// 这里我甚至可以省略 static 和 string[] args, 但是 static 保留也没有问题

        List<String> list = List.of("1", "2", "3");

        int count = 0;

        for (String _ : list) {
            count ++; // 我其实根本不需要这个变量
        }

        System.out.println(count);

        try {
            Integer.parseInt(list.getLast());
        } catch (NumberFormatException _) {
            System.out.println("我根本不需要exception 的变量名，所以就可以用 _ 代替");
        }

    }
}
