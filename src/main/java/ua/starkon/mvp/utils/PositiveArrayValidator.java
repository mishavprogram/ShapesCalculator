package ua.starkon.mvp.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PositiveArrayValidator implements ConstraintValidator<PositiveArray, double[]> {

    @Override
    public boolean isValid(double[] values, ConstraintValidatorContext context) {
        if (values == null) {
            return false;
        }
        for (double value : values) {
            if (value <= 0) {
                return false;
            }
        }
        return true;
    }
}