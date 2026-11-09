package edu.course.lab03;

import edu.course.lab03.policy.DiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountPolicyTest {

    @Test
    void testNoDiscount() {
        DiscountPolicy noDiscount = new NoDiscount();
        PriceCalculator calculator = new PriceCalculator(noDiscount);

        assertEquals(100.0, calculator.calculate(100.0));
        assertEquals(0.0, calculator.calculate(0.0));
    }

    @Test
    void testPercentDiscount() {
        DiscountPolicy percentDiscount = new PercentDiscount(20.0);
        PriceCalculator calculator = new PriceCalculator(percentDiscount);

        assertEquals(80.0, calculator.calculate(100.0));
    }

    @Test
    void testNegativePriceIsForbidden() {
        DiscountPolicy noDiscount = new NoDiscount();
        DiscountPolicy percentDiscount = new PercentDiscount(10.0);

        assertThrows(IllegalArgumentException.class, () -> noDiscount.apply(-50));
        assertThrows(IllegalArgumentException.class, () -> percentDiscount.apply(-10));
    }

    @Test
    void testPolicyReplacement() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calculator.calculate(100.0));

        calculator.setDiscountPolicy(new PercentDiscount(20.0));
        assertEquals(80.0, calculator.calculate(100.0));
    }
}
