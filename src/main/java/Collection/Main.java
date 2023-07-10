package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 创建一个列表(List)并添加元素
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // 遍历列表并打印元素
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 创建一个映射(Map)并添加键值对
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Mary", 30);
        ages.put("Tom", 28);

        // 遍历映射并打印键值对
        System.out.println("Ages:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            String name = entry.getKey();
            int age = entry.getValue();
            System.out.println(name + " : " + age);
        }
    }
}









