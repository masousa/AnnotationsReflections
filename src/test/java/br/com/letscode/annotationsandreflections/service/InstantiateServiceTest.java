package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.domains.Endereco;
import br.com.letscode.annotationsandreflections.domains.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class InstantiateServiceTest {

    @Test
    public void should_return_an_endereco_with_default_value() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Endereco endereco = InstantiateService.execute(Endereco.class);

        Assert.assertEquals(endereco.getNumero(),"SN" );
    }

    @Test
    public void should_return_an_funcionario_with_default_value() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Funcionario funcionario = InstantiateService.execute(Funcionario.class);

        Assert.assertEquals(funcionario.getMatricula(),"SM" );
    }
}
