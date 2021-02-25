package com.airbnb.lottie;

import java.lang.annotation.Annotation;

import com.airbnb.lottie.Nonnull;

public interface TypeQualifierValidator<A extends Annotation> {
    /**
     * Given a type qualifier, check to see if a known specific constant value
     * is an instance of the set of values denoted by the qualifier.
     * 
     * @param annotation
     *                the type qualifier
     * @param value
     *                the value to check
     * @return a value indicating whether or not the value is an member of the
     *         values denoted by the type qualifier
     */
    public @Nonnull
    When forConstantValue(@Nonnull A annotation, Object value);
}
