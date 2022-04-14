package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.annotations.Default;
import br.com.letscode.annotationsandreflections.annotations.DefaultData;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Objects;

@UtilityClass
public class InstantiateService {

    public <T> T execute(Class<T> classObject, LocalDate localDate) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        T object = (T) classObject.getDeclaredConstructors()[0].newInstance();
        for (Field field: object.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Default.class)){
                Default defaultObjectValue = field.getAnnotation(Default.class);
                Object value = defaultObjectValue.value();
                field.setAccessible(true);
                field.set(object,value);
            }
            if(field.isAnnotationPresent(DefaultData.class)){
                DefaultData defaultObjectValue = field.getAnnotation(DefaultData.class);
                LocalDate date = LocalDate.now();
                if(!defaultObjectValue.currentDate() && Objects.nonNull(localDate)){
                    date = localDate;
                }
                field.setAccessible(true);

                field.set(object, date);
            }
        }
        return object;
    }
}
