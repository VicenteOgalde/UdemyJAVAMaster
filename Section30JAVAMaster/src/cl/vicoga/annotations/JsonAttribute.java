package cl.vicoga.annotations;

import java.lang.annotation.*;


@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAttribute {

    String name() default "";

}
