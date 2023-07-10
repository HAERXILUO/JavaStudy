package Generic_Class;

import java.util.Arrays;
import java.util.List;

class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class Util{
    public static <T> T getFirstElement(T[] array) {
        return array[0];
    }

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 泛型类示例
        Box<Integer> box1 = new Box<>();
        box1.setItem(10);
        int value = box1.getItem(); // 自动拆箱
        System.out.println(value);

        Box<String> box2 = new Box<>();
        box2.setItem("Hello");
        String str = box2.getItem();
        System.out.println(str);

        // 泛型方法示例
        Integer[] numbers = {1, 2, 3};
        Integer first = Util.<Integer>getFirstElement(numbers);
        System.out.println(first);

        // 通配符示例
        List<Integer> numberList = Arrays.asList(1, 2, 3);
        Util.printList(numberList);

        List<String> nameList = Arrays.asList("John", "Mary", "Tom");
        Util.printList(nameList);
    }
}



