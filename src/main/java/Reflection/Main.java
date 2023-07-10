package Reflection;

//在Java中，反射是一种强大的机制，允许在运行时检查和操作类、对象、方法和属性的信息。下面是一些关于反射的重要知识点：
//
//获取Class对象：可以使用以下方法获取表示类的Class对象：
//
//使用类名.class语法：Class<?> clazz = MyClass.class;
//使用对象.getClass()方法：Class<?> clazz = myObject.getClass();
//使用Class.forName()方法：Class<?> clazz = Class.forName("com.example.MyClass");

//创建对象：通过反射可以实例化类对象，可以使用以下方法创建对象：
//使用Class对象的newInstance()方法（已过时）：MyClass obj = clazz.newInstance();
//使用Constructor类的newInstance()方法：Constructor<MyClass> constructor = clazz.getConstructor(); MyClass obj = constructor.newInstance();
//调用方法：反射可以调用类中的方法，包括公共方法和私有方法。可以使用以下方法调用方法：
//
//使用Method类的invoke()方法：Method method = clazz.getMethod("methodName", parameterTypes); method.invoke(obj, args);

//访问字段：通过反射可以访问类中的字段（属性），包括公共字段和私有字段。可以使用以下方法访问字段：
//使用Field类的get()和set()方法：Field field = clazz.getField("fieldName"); Object value = field.get(obj); field.set(obj, value);

//获取类信息：反射可以获取有关类的详细信息，包括类名、父类、接口、方法、字段等。可以使用以下方法获取类信息：
//使用Class类的getSuperclass()方法：Class<?> superClass = clazz.getSuperclass();
//使用Class类的getInterfaces()方法：Class<?>[] interfaces = clazz.getInterfaces();
//使用Class类的getMethods()方法：Method[] methods = clazz.getMethods();
//使用Class类的getFields()方法：Field[] fields = clazz.getFields();

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class<?> clazz = MyClass.class;

        // 创建对象
        Constructor<?> constructor = clazz.getConstructor();
        MyClass obj = (MyClass) constructor.newInstance();
//        obj.hello();
        // 调用方法
        Method method = clazz.getMethod("hello");
        method.invoke(obj);

        // 访问字段
        Field field = clazz.getField("name");
        field.set(obj, "John");
        System.out.println("Name: " + field.get(obj));
    }
}

class MyClass {
    public String name;

    public MyClass() {
        this.name = "Default";
    }

    public void hello() {
        System.out.println("Hello, World!");
    }
}

