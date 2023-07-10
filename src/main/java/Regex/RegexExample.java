package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {
        String text = "Hello, my email is example@example.com. Please contact me at 844125340@qq.com.";

        String patternString = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
//        使用 Pattern.compile() 方法将正则表达式编译为一个 Pattern 对象。
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
//        创建一个 Matcher 对象，并使用 matcher() 方法将其绑定到我们要匹配的字符串上。
//        我们使用 find() 方法在字符串中查找匹配项，并使用 group() 方法提取匹配的字符串。
        while (matcher.find()) {
            String email = matcher.group();
            System.out.println("Email found: " + email);
        }
    }
}

