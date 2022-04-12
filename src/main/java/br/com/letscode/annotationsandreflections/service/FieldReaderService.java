package br.com.letscode.annotationsandreflections.service;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class FieldReaderService {
    public static <T> String execute(T object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        for (Field field : fields) {
            String name = field.getName();
            field.setAccessible(true);
            Object value = field.get(object);
            if(Objects.nonNull(value)) {
                builder.append(String.format("%s -- %s %n", name, value));

            }
        }
        return builder.toString();
    }

}
