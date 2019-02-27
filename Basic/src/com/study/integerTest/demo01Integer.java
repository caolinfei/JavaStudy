package com.study.integerTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class demo01Integer {

    /*
    *   | 基本类型    | 对应的包装类（位于java.lang包中） |
        | ------- | --------------------- |
        | byte    | Byte                  |
        | short   | Short                 |
        | int     | **demo01Integer**           |
        | long    | Long                  |
        | float   | Float                 |
        | double  | Double                |
        | char    | **Character**         |
        | boolean | Boolean               |
    * */
    public static void main(String[] args) {
        Integer integer =1; //自动装箱

        int i=integer;

        int i1=integer.intValue();

        String[] strings=new  String[]{"1","s"};
        Stream<String> stringStream = Arrays.stream(strings).parallel().filter((m) -> {
            return !Objects.nonNull(m) ||!m.equals("");
        });



    }


}
