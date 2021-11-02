package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        Class c = Test_class.class;
        Constructor<Test_class> con = c.getConstructor();
        Test_class test_cl = con.newInstance();
        Method[] methods = c.getDeclaredMethods();
        ArrayList<Method> arrl = new ArrayList<>();
        Method beforeSuite = null;
        Method afterSuite = null;
        for ( Method method: methods) {
            if (method.isAnnotationPresent(Test.class)) {
                arrl.add(method);
            }
            if (method.isAnnotationPresent(Arr.BeforeSuite.class)) {
                if (beforeSuite == null) beforeSuite = method;
                else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
            }
            if (method.isAnnotationPresent(Arr.AfterSuite.class)) {
                if (afterSuite == null) afterSuite = method;
                else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            arrl.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
                }
            });
        }

        if (beforeSuite != null) beforeSuite.invoke(test_cl, null);
        for (Method method : arrl) method.invoke(test_cl, null);
        if (afterSuite != null) afterSuite.invoke(test_cl, null);
    }
}
