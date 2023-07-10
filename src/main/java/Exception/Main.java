package Exception;

//异常分类：Java中的异常分为两种类型：
//
//受检异常（Checked Exception）：必须在代码中显式地进行捕获和处理，否则编译错误。例如，IOException、SQLException等。
//非受检异常（Unchecked Exception）：不要求显式地进行捕获和处理，可以选择性地处理。例如，NullPointerException、ArrayIndexOutOfBoundsException等。

//try-catch语句块：用于捕获和处理异常。在try块中编写可能引发异常的代码，然后通过catch块来捕获并处理异常。一个try块可以跟随多个catch块，用于处理不同类型的异常。
//throws关键字：用于在方法声明中指定该方法可能抛出的异常类型，将异常的处理责任交给调用该方法的代码。
//finally块：可选的finally块用于执行无论是否发生异常都必须执行的代码。在try块和catch块之后执行，无论异常是否被捕获和处理，都会执行finally块的代码。

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            readFile("example.txt");
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } finally {
            System.out.println("程序执行完毕");
        }
    }

    public static void readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}



