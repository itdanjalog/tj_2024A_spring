package example.day07.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;


class MyObject {
    @MyAnnotation
    public void testMethod1() {
        System.out.println("This is testMethod1");
    }

    @MyAnnotation(value = "My new Annotation2")
    public void testMethod2() {
        System.out.println("This is testMethod2");
    }
    @MyAnnotation(value = "My new Annotation3" , value2 = "유재석")
    public void testMethod3() {
        System.out.println("This is testMethod3");
    }
}
public class Step1 {
    public static void main(String[] args) {
        Method[] methodList = MyObject.class.getMethods();
        
        for (Method method : methodList) {
            //System.out.println("method = " + method);
            if(method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation=method.getDeclaredAnnotation(MyAnnotation.class);
                String value=annotation.value();
                String value2=annotation.value2();
                System.out.println(method.getName() + ":" + value);
                System.out.println(method.getName() + ":" + value2);
            }
        }


    }
}

class OldClass {
    @Deprecated
    void oldMethod() {
        System.out.println("This method is old and not recommended.");
    }
}