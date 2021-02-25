package com.airbnb.lottie;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Class retained Nullable annotation.
 *
 * Purely used to assist IDE auto-completion for users of Ebean API.
 * This is expected to be in maven provided scope only.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Nullable {

}
