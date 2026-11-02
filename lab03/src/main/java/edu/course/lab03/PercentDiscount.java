package edu.course.lab03;

import edu.course.lab03.policy.DiscountPolicy;

public class PercentDiscount implements DiscountPolicy {
    private final double percent;

    public PercentDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Процент должен в диапозоне от 0 до 100");
        }
        this.percent = percent;
    }

    @Override
    public double apply(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Не может быть отрицательной");
        }
        return price * (1 - percent / 100.0);
    }
}
