package ua.starkon.mvp.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PositiveArrayValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveArray {

    String message() default "All elements in the array must be positive";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}