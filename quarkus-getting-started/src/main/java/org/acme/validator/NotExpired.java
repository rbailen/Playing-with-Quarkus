package org.acme.validator;

import org.acme.validator.NotExpiredValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NotExpiredValidator.class})
public @interface NotExpired {

    String message() default "Beer must not be expired";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
