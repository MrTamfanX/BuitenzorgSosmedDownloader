package com.airbnb.lottie;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.airbnb.lottie.TypeQualifier;
import com.airbnb.lottie.TypeQualifierValidator;
import com.airbnb.lottie.When;

@Documented
@TypeQualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnull {
    When when() default When.ALWAYS;

    static class Checker implements TypeQualifierValidator<Nonnull> {

        public When forConstantValue(Nonnull qualifierqualifierArgument,
                Object value) {
            if (value == null)
                return When.NEVER;
            return When.ALWAYS;
        }
    }
}
