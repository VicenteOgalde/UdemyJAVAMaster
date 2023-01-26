package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.model.Test;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static final List<Test> DATA_TEST = Arrays.asList(
            new Test(1L,"t1"),
            new Test(2L,"t2"),
            new Test(3L,"t3"));
    public static final List<String> DATA_QUESTION= Arrays.asList(
            "t1q10","t1q20","t2q15"
    );
    public static final Test TEST= new Test(8L,"t8");
}
