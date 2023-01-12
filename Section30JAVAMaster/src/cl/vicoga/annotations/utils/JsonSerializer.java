package cl.vicoga.annotations.utils;

import cl.vicoga.annotations.JsonAttribute;
import cl.vicoga.annotations.exception.JsonSerializerException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public class JsonSerializer {

    public static String turnToJson(Object obj) {

        if(Objects.isNull(obj)){
            throw new JsonSerializerException("the object cant be null");
        }

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
                            newValue=newValue.substring(0,1).toUpperCase()+newValue.substring(1).toLowerCase();
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
