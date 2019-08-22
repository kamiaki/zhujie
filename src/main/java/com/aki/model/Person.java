package com.aki.model;

import com.aki.annotation.ClassAnnotation;
import com.aki.annotation.FieldAnnotation;
import com.aki.annotation.MethodAnnotation;
import com.aki.enumPackage.MethodTypeEnum;

@ClassAnnotation(name="personBean", version="1.2.1")
public class Person {
    @FieldAnnotation(name = "description", value = "给参数赋的值")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @MethodAnnotation(name = "sayHello", type = MethodTypeEnum.TYPE2)
    public void sayHello() {
        System.out.println("Hello Annotation!");
    }
}
