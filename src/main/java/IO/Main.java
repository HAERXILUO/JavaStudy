package IO;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 文件IO示例
        try {
            // 写入文件
            String content = "Hello, World!";
            FileWriter writer = new FileWriter("output.txt");
            writer.write(content);
            writer.close();

            // 读取文件
            FileReader reader = new FileReader("output.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 标准IO示例
        try {
            // 从标准输入读取数据
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            System.out.print("Enter your name: ");
            String name = bufferedReader.readLine();
            System.out.println("Hello, " + name);

            // 输出到标准输出
            System.out.println("This is a message to the standard output.");
            // 输出到标准错误
            System.err.println("This is an error message to the standard error.");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: "+scanner.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





