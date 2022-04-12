package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.annotations.Default;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@UtilityClass
public class InstantiateService {

    public <T> T execute(Class<T> classObject) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        T object = (T) classObject.getDeclaredConstructors()[0].newInstance();
        for (Field field: object.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Default.class)){
                Default defaultObjectValue = field.getAnnotation(Default.class);
                Object value = defaultObjectValue.value();
                field.setAccessible(true);
                field.set(object,value);
            }
        }
        return object;
    }
}
