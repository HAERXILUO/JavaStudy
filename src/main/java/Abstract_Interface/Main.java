package Abstract_Interface;

//在Java中，抽象类和接口是面向对象编程中的两个重要概念，用于实现类的继承和多态。下面是关于抽象类和接口的一些重要知识点：
//
//抽象类：
//1. 抽象类是用`abstract`关键字声明的类，它不能被实例化，只能被继承。
//2. 抽象类可以包含抽象方法和非抽象方法。
//3. 抽象方法是没有具体实现的方法，只有方法的声明，子类必须实现抽象方法。
//4. 子类继承抽象类后，必须实现抽象方法，除非子类也声明为抽象类。
//
//接口：
//1. 接口是用`interface`关键字声明的，它定义了一组抽象方法和常量的集合。
//2. 接口中的方法都是抽象方法，不包含具体实现。
//3. 类通过`implements`关键字实现接口，一个类可以实现多个接口。
//4. 实现接口的类必须实现接口中的所有抽象方法，否则需要将类本身也声明为抽象类。
//5. 接口可以被其他接口继承，形成接口的继承关系。
//
//下面是一个简单的Java代码示例，演示了抽象类和接口的使用：
//
//```java
// 抽象类
abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println(name + " is eating");
    }
}

// 接口
interface Jumpable {
    void jump();
}

// 具体类实现抽象类和接口
class Dog extends Animal implements Jumpable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks");
    }

    @Override
    public void jump() {
        System.out.println(name + " jumps");
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.makeSound();  // 输出 "Buddy barks"
        dog.eat();        // 输出 "Buddy is eating"
        dog.jump();       // 输出 "Buddy jumps"

        Animal animal = new Dog("Max");
        animal.makeSound();  // 输出 "Max barks"
        animal.eat();        // 输出 "Max is eating"
        // animal.jump();    // 错误，Animal 类型不能调用 jump() 方法
    }
}

//```
//
//在上述示例中，`Animal`是抽象类，其中包含了一个抽象方法`makeSound()`和一个非抽象方法`eat()`。`Jumpable`是接口，定义了一个抽象方法`jump()`。
//
//`Dog`类继承了`Animal`抽象类，并实现了`Jumpable`接口。在`Dog`类中，我们必须实现抽象方法`makeSound

//抽象类的重用：
//抽象类可以作为其他具体类的基类，通过继承抽象类，子类可以获取抽象类中定义的属性和方法，并进行重写或扩展。
//抽象类可以定义通用的方法和行为，提供一些默认实现，子类可以选择性地覆盖这些方法。
//抽象类可以约束子类的行为，通过定义抽象方法，强制子类实现特定的行为。

//接口的重用：
//接口可以定义一组规范和契约，用于描述对象的行为和功能。其他类可以实现接口，以满足这些规范。
//接口提供了一种松耦合的方式，允许类与类之间通过接口进行交互，而不依赖于具体的实现类。
//接口可以实现多重继承，一个类可以实现多个接口，从而获得多个接口定义的方法和行为。
//接口在定义回调和事件处理等机制时非常有用，允许对象通过接口与外部进行通信和交互。
//在实际工作中，可以根据需求选择合适的重用方式：
//
//当多个类具有共同的属性和行为，并且需要提供默认实现时，可以使用抽象类进行重用。
//当多个类需要实现一组规范和契约，并且类之间关系较松散时，可以使用接口进行重用。
//如果一个类既需要继承某个基类，又需要实现一组规范，那么可以同时使用抽象类和接口，实现多重继承和行为约束。
//通过合理使用抽象类和接口，可以提高代码的可重用性、灵活性和可扩展性，同时实现代码的解耦和模块化。
