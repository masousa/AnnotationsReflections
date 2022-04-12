package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.annotations.Format;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class GetFormattedDataService {
    public <T> Map<String,String> execute(T object) throws IllegalAccessException {
        Map<String,String> valueMap = new HashMap<>();

        //TODO (2) criar instrução para verificar se anotação Format existe na declaração do
         // método. Caso exista. Executar o método, receber o retorno (localdate) e formatar
         // Adicionando o mesmo no mapa.
        for (Field field : object.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Format.class)){
                Format format = field.getAnnotation(Format.class);
                String pattern = format.pattern();
                field.setAccessible(true);
                Object value = field.get(object);
                if(Objects.nonNull(value)){
                    LocalDate localDate = (LocalDate) value;
                    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                    valueMap.put(field.getName(),
                            localDate.format(formatter));
                }

            }
        }

        return valueMap;
    }
}
