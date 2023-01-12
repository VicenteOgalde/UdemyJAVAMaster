package cl.vicoga.annotations;

import cl.vicoga.annotations.model.Product;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class TestAnnotation {
    public static void main(String[] args) {


        Product p  = new Product();
        p.setDate(LocalDate.now());
        p.setPrice(5000L);
        p.setName("tv");

        Field[] att= p.getClass().getDeclaredFields();

        String json= Arrays.stream(att)
                .filter(f-> f.isAnnotationPresent(JsonAttribute.class))
                .map(f->{
                    f.setAccessible(true);
                    String name= f.getAnnotation(JsonAttribute.class).name().equals("")
                    ? f.getName() : f.getAnnotation(JsonAttribute.class).name();

                    try {
                        return "\""+name+"\":\""+f.get(p)+"\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("error json: "+e.getMessage());
                    }

                } )
                .reduce("{",(a,b)->{
                    if("{".equals(a)){
                        return a+b;
                    }
                    return a+", "+b;

                }).concat("}");

        System.out.println("json = " + json);
    }
}
