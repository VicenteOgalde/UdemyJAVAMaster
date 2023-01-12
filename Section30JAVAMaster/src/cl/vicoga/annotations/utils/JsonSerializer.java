package cl.vicoga.annotations.utils;

import cl.vicoga.annotations.Init;
import cl.vicoga.annotations.JsonAttribute;
import cl.vicoga.annotations.exception.JsonSerializerException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializer {

    public static void objectInit(Object obj){
        if(Objects.isNull(obj)){
            throw new JsonSerializerException("the object cant be null");
        }
        Method [] methods= obj.getClass().getDeclaredMethods();
        Arrays.stream(methods).filter(f-> f.isAnnotationPresent(Init.class))
                .forEach(m-> {
                    try {
                        m.invoke(obj);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializerException("cant initialize the object "+e.getMessage());
                    }
                });


    }
    public static String turnToJson(Object obj) {

        if(Objects.isNull(obj)){
            throw new JsonSerializerException("the object cant be null");
        }
        objectInit(obj);

        Field[] att = obj.getClass().getDeclaredFields();
        return Arrays.stream(att)
                .filter(f -> f.isAnnotationPresent(JsonAttribute.class))
                .map(f -> {
                    f.setAccessible(true);
                    String name = f.getAnnotation(JsonAttribute.class).name().equals("")
                            ? f.getName() : f.getAnnotation(JsonAttribute.class).name();

                    try {
                        Object o = f.get(obj);
                        if(f.getAnnotation(JsonAttribute.class).capitalize()
                        && o instanceof String){
                            String newValue = (String) o;
                            newValue=Arrays.stream(newValue.split(" "))
                                            .map(e->e=e.substring(0,1).toUpperCase()+
                                                    e.substring(1).toLowerCase())
                                                    .collect(Collectors.joining(" "));

                            f.set(obj,newValue);
                        }

                        return "\"" + name + "\":\"" + f.get(obj) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializerException("error json: " + e.getMessage());
                    }

                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)) {
                        return a + b;
                    }
                    return a + ", " + b;

                }).concat("}");

    }
}
