package com.aki.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {
    public String name() default "defaultName";
    public String value() default "defaultValue";
}