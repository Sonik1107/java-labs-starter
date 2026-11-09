package edu.course.lab03;

import edu.course.lab03.policy.DiscountPolicy;

public class NoDiscount implements DiscountPolicy {
    @Override
    public double apply(double price) {
        if (price < 0) {
          throw new IllegalArgumentException("Не может быть отрицательной");
        }
        return price;
    }
}
