package com.j13.v2.server.poppy.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface Parameter {

    public String desc() default "";

    public String name() default "";

}
