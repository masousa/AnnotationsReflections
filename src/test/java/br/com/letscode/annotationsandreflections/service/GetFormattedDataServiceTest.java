package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.domains.Funcionario;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class GetFormattedDataServiceTest {

    @Test
    public void should_return_two_different_patterns_dataNascimento_diaInicioTrabalho() throws IllegalAccessException, InvocationTargetException {
        LocalDate localDate = LocalDate.now();

        Funcionario funcionario = new Funcionario();

        funcionario.setDataNascimento(localDate);
        funcionario.setDataInicioTrabalho(localDate);

        Map<String,String> returnedMap = GetFormattedDataService.execute(funcionario);


        assertThat(returnedMap).containsKeys("dataNascimento","getDataInicioTrabalho");

        assertThat(returnedMap.get("getDataInicioTrabalho"))
                .isEqualTo(localDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        assertThat(returnedMap.get("dataNascimento"))
                .isEqualTo(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));


    }
}
