package jdk16;

/**
 *
 * 1, 不能用 abstract 修饰 Record 类，会有编译错误。
 * 2, 可以用 final 修饰 Record 类，但是这其实是没有必要的，因为 Record 类本身就是 final 的。
 * 3, 如果类内申明有 record 类，那么这个类就是 static 自动是的
 * 4, Record 类的直接父类不是 java.lang.Object 而是 java.lang.Record
 * 5, Record 类不能继承任何类
 * 6, Record 类属性必须在头部声明，在 Record 类体只能声明静态属性
 * 7, 但 Record 类可以有非静态方法
 * 8, 但是不能是 native 方法
 *
 */
public record Book(String title, String author, String isbn) {
    static {
        System.out.println("===============================");
    }

    public Book {
        title = title  + "_vincent";
    }
}
