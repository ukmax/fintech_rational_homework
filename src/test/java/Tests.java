import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testLess(){
        Rational r1 = new Rational(2, 4);
        Rational r2 = new Rational(3,9);
        assertTrue("Equal or greater, not less", r2.less(r1));
    }

    @Test
    public void testEqual(){
        Rational r1 = new Rational(2, 4);
        Rational r2 = new Rational(2,4);
        assertTrue("Is not equal", r2.equals(r1));
    }

    @Test
    public void testLessOrEqual(){
        int num = 2;
        int den = 3;
        Rational r = new Rational(num, den);
        Rational r1 = new Rational(num, den);
        assertTrue("Is not equal", r1.lessOrEqual(r));
        num = num -1; //уменьшаем числитель на 1, чтобы проверить, что дробь стала меньше и проверка все еще срабатывает
        Rational r2 = new Rational(num, den);
        assertTrue("Is not less", r2.lessOrEqual(r));
    }

    @Test
    public void testPlus(){
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(1,2);
        Rational result = r1.plus(r2);
        assertEquals("Wrong numerator", 7, result.getNumerator());
        assertEquals("Wrong denominator", 6, result.getDenominator());
    }

    @Test
    public void testMinus(){
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(1,2);
        Rational result = r1.minus(r2);
        assertEquals("Wrong numerator", 1, result.getNumerator());
        assertEquals("Wrong denominator", 6, result.getDenominator());
    }

    @Test
    public void testMultiply(){
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(1,2);
        Rational result = r1.multiply(r2);
        assertEquals("Wrong numerator", 1, result.getNumerator());
        assertEquals("Wrong denominator", 3, result.getDenominator());
    }

    @Test
    public void testDevide(){
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(1,2);
        Rational result = r1.divide(r2);
        assertEquals("Wrong numerator", 4, result.getNumerator());
        assertEquals("Wrong denominator", 3, result.getDenominator());
    }

    @Test
    public void testReduce(){
        Rational r = new Rational(20, 15);
        assertEquals("Wrong numerator", 4, r.getNumerator());
        assertEquals("Wrong denominator", 3, r.getDenominator());
    }

    @Test
    public void testSimplifyMinuses(){
        Rational r = new Rational(2, -3);
        assertEquals("Wrong numerator", -2, r.getNumerator());
        assertEquals("Wrong denominator", 3, r.getDenominator());
    }

    @Test
    public void testCreateZeroDenominatorException(){
        try {
            Rational r = new Rational(2, 0);
        }
        catch (ArithmeticException e) {
            assertEquals("Wrong error", "division by zero !", e.getMessage());
        }
    }

    @Test
    public void testDivisionByZeroException(){
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(0, 2);
        try {
            Rational r = r1.divide(r2);
        }
        catch (ArithmeticException e) {
            assertEquals("Wrong error", "division by zero !", e.getMessage());
        }
    }
}
