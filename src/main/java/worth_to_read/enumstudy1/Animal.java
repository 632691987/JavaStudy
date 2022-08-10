package worth_to_read.enumstudy1;

/**
 *
 * 这个例子说明，
 *
 * 枚举类是可以有 abstract 函数在里面的，而每个元素都是他的子类, 并且在元素内部实现 implementation
 *
 *
 */
public enum Animal {
    CAT {
        public String makeNoise() { return "MEOW!"; }
        @Override
        public void sayHi(){
            System.out.println("Cat say HI ");
        }
    },
    DOG {
        public String makeNoise() { return "WOOF!"; }

        @Override
        public void sayHi(){
            System.out.println("Dog say HI ");
        }
    };

    public abstract String makeNoise();

    public void sayHi(){
        System.out.println("Animal say hi");
    }

    public static void main(String[] args) {
        Animal.CAT.sayHi();
        Animal.DOG.sayHi();
    }
}