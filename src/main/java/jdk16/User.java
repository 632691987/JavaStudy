package jdk16;

public record User(long id, String name, int age) {
    public User {
        System.out.println("initialized");
        id = 1000 + id;
        name = "prefix_" + name;
        name = "prefix_" + name;
        age = 1 + age;
        age = 1 + age;
        age = 1 + age;
        age = 1 + age;
    }

    public static void main(String[] args) {
        User user = new User(23L, "name", 12);
        System.out.println(user.id());
        System.out.println(user.age());
        System.out.println(user.name());
    }
}