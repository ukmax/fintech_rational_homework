import org.junit.Test;
import static org.junit.Assert.*;

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
}