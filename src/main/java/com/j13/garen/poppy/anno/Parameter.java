package com.j13.garen.poppy.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface Parameter {

    public String desc() default "";

    public String name() default "";

}
