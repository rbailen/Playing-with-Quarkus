package org.acme.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotExpiredValidator implements ConstraintValidator<NotExpired, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if(null == value){
            return true;
        }

        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(now, value) > 0;
    }
}
