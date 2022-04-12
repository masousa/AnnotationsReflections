package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.domains.Endereco;
import org.junit.Assert;
import org.junit.Test;

public class FieldReaderServiceTest {


    @Test
    public void should_return_an_empty_list_given_an_empty_created_object() throws IllegalAccessException {
        Endereco endereco = new Endereco();
        String values = FieldReaderService.execute(endereco);
        Assert.assertTrue(values.isEmpty());
    }

    @Test
    public void should_return_a_non_empty_list_given_created_object_with_some_values_informed() throws IllegalAccessException {
        Endereco endereco = new Endereco();
        endereco.setBairro("bairro exemplo");
        endereco.setNumero("12");
        String values = FieldReaderService.execute(endereco);
        Assert.assertFalse(values.isEmpty());
    }
}
