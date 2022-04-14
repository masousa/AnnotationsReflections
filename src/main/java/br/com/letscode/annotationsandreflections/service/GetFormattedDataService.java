package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.annotations.Format;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class GetFormattedDataService {
    public <T> Map<String,String> execute(T object) throws IllegalAccessException, InvocationTargetException {
        Map<String,String> valueMap = new HashMap<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Format.class)){
                Format format = field.getAnnotation(Format.class);
                String pattern = format.pattern();
                field.setAccessible(true);
                Object value = field.get(object);
                addToMap(value, pattern, valueMap, field.getName());

            }
        }
        for (Method method: object.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(Format.class)){
                Format format = method.getAnnotation(Format.class);
                String pattern = format.pattern();
                Object value = method.invoke(object);
                addToMap(value, pattern, valueMap, method.getName());
            }

        }

        return valueMap;
    }

    private void addToMap(Object value, String pattern, Map<String, String> valueMap, String method) {
        if(Objects.nonNull(value)){
            LocalDate localDate = (LocalDate) value;
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            valueMap.put(method,
                    localDate.format(formatter));
        }
    }
}
