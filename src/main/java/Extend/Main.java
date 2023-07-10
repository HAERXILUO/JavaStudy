package Extend;

//在Java中，继承是一种重要的面向对象编程的概念，它允许一个类（称为子类或派生类）继承另一个类（称为父类或基类）的属性和方法。继承的一些重要知识点如下：
//
//1. 单继承：Java中的类只能单继承，即一个子类只能有一个直接的父类。
//
//2. extends关键字：使用extends关键字来声明一个类继承自另一个类。子类可以继承父类的非私有成员变量和方法。
//
//3. 父类与子类关系：子类继承父类，子类可以访问父类的非私有成员变量和方法。父类的私有成员变量和方法对子类不可见。
//
//4. 方法重写：子类可以重写父类的方法，即子类可以提供与父类具有相同名称、参数列表和返回类型的方法。通过方法重写，子类可以根据自身需求改变方法的实现。
//
//5. super关键字：super关键字用于访问父类的成员变量和方法。子类中可以使用super来调用父类的构造方法、访问父类的成员变量和调用父类的方法。
//
//下面是一个简单的Java代码示例，演示了继承的使用：
//
//```java
//// 父类
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

// 子类
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public void wagTail() {
        System.out.println("Dog wags tail");
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.makeSound();  // 调用子类的方法，输出 "Dog barks"
        dog.wagTail();    // 调用子类特有的方法，输出 "Dog wags tail"

        // 使用父类的引用指向子类的对象
        Animal animal = new Dog("Max");
        animal.makeSound();  // 调用子类的方法，输出 "Dog barks"
        // animal.wagTail();  // 父类的引用无法调用子类特有的方法

        // 使用父类的引用指向父类的对象
        Animal animal2 = new Animal("Generic Animal");
        animal2.makeSound();  // 调用父类的方法，输出 "Animal makes sound"
    }
}
//```
//
//在上述示例中，`Animal`是父类，`Dog`是子类。子类`Dog`继承了父类`Animal`的属性和方法，包括`name`成员变量和`makeSound()`方法
//
//。子类`Dog`还新增了自己特有的方法`wagTail()`。
//
//在`Main`测试类中，我们创建了一个`Dog`对象，并调用了子类和父类的方法。通过使用父类的引用指向子类的对象，我们可以灵活地使用继承的特性。
//
