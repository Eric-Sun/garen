package com.j13.v2.server.poppy.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Action {

    public String name() default "";

    public String desc() default "";

}
