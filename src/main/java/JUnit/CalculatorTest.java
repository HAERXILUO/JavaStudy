package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//通过在 testAddition() 和 testSubtraction() 方法上使用 @Test 注解，
// 我们定义了两个测试方法来验证 add() 和 subtract() 方法的行为是否符合预期。
// 在这两个测试方法中，我们使用断言方法 assertEquals() 来比较计算结果和预期值。
public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(4, 2);
        assertEquals(2, result);
    }

    public static void main(String[] args) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> {
            CalculatorTest calculatorTest = new CalculatorTest();
            calculatorTest.testAddition();
            calculatorTest.testSubtraction();
        });
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
}





