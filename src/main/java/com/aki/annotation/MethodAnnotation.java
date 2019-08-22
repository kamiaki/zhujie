package com.aki.annotation;

import com.aki.enumPackage.MethodTypeEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodAnnotation {
    public String name() default "defaultName";

    public MethodTypeEnum type() default MethodTypeEnum.TYPE1;
}