package br.com.letscode.annotationsandreflections.service;

import br.com.letscode.annotationsandreflections.domains.Endereco;
import br.com.letscode.annotationsandreflections.domains.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class InstantiateServiceTest {

    @Test
    public void should_return_an_endereco_with_default_value() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Endereco endereco = InstantiateService.execute(Endereco.class,null);

        Assert.assertEquals(endereco.getNumero(),"SN" );
    }

    @Test
    public void should_return_an_funcionario_with_default_value() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Funcionario funcionario = InstantiateService.execute(Funcionario.class,null);

        Assert.assertEquals(funcionario.getMatricula(),"SM" );
        Assert.assertNotNull(funcionario.getDataInicioTrabalho());
    }

    @Test
    public void should_return_an_endereco_with_default_value_data() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        LocalDate localDate = LocalDate.now().minusMonths(4);
        Endereco endereco = InstantiateService.execute(Endereco.class,localDate);
        Assert.assertNotNull(endereco.getDataCadastro());
        Assert.assertNotEquals(endereco.getDataCadastro(), LocalDate.now());
    }
}
