package worth_to_read.enumstudy2;

/**
 *
 * 这个例子说明，枚举类还能 implement interface, 但不能继承类
 *
 *
 */
public enum SimpleOperators implements Operator{

    PLUS {
        public int apply(int a, int b) { return a + b; }
    },
    MINUS {
        public int apply(int a, int b) { return a - b; }
    };

}
