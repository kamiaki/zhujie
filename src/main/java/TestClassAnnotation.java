import com.aki.annotation.ClassAnnotation;
import com.aki.annotation.FieldAnnotation;
import com.aki.annotation.MethodAnnotation;
import com.aki.model.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestClassAnnotation {
    private static Person person = new Person();

    static void classzhujie()throws Exception{
        Class<?> clazz = person.getClass();
        //因为注解是作用于类上面的，所以可以通过isAnnotationPresent来判断是否是一个具有指定注解的类
        if (clazz.isAnnotationPresent(ClassAnnotation.class)) {
            System.out.println("这是一个有注解的类");
            //通过getAnnotation可以获取注解对象
            ClassAnnotation annotation = clazz.getAnnotation(ClassAnnotation.class);
            if (null != annotation) {
                System.out.println("BeanName = " + annotation.name());
                System.out.println("BeanVersion = " + annotation.version());
            } else {
                System.out.println("注解为null");
            }
        } else {
            System.out.println("这个类没注解");
        }
    }
    static void methodzhujie()throws Exception{
        Class<?> clazz = person.getClass();
        //因为是注解到method上的，所以首先要获取这个方法
//        Method method = clazz.getDeclaredMethod("sayHello");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodAnnotation.class)) {
                System.out.println("这是一个有注解的类");
                //通过getAnnotation可以获取注解对象
                MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
                if (null != annotation) {
                    System.out.println("MethodName  = " + annotation.name());
                    System.out.println("MethodType  = " + annotation.type());
                } else {
                    System.out.println("注解为null");
                }
            } else {
                System.out.println("这个类没注解");
            }
        }
    }
    static void fieldzhujie()throws Exception{
        Class<?> clazz = person.getClass();
        //因为是注解到Field上的，所以首先要获取这个字段
//        Field field = clazz.getDeclaredField("description");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldAnnotation.class)) {
                System.out.println("这是一个有注解的类");
                //通过getAnnotation可以获取注解对象
                FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
                if (null != annotation) {
                    System.out.println("赋值前,value:" + person.getDescription());
                    //通过反射给私有变量赋值
                    field.setAccessible(true);
                    field.set(person, annotation.value());
                    System.out.println("赋值后,value:" + person.getDescription());
                    System.out.println("name = " + annotation.name());
                    System.out.println("value = " + annotation.value());
                } else {
                    System.out.println("注解为null");
                }
            } else {
                System.out.println("这个类没注解");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        classzhujie();
        methodzhujie();
        fieldzhujie();
    }
}
