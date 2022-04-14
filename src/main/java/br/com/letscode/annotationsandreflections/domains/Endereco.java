package br.com.letscode.annotationsandreflections.domains;

import br.com.letscode.annotationsandreflections.annotations.Default;
import br.com.letscode.annotationsandreflections.annotations.DefaultData;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Endereco {

    private String bairro;
    private String cep;
    private String rua;
    @Default(value = "SN")
    private String numero;

    @DefaultData(currentDate = false)
    private LocalDate dataCadastro;
}
