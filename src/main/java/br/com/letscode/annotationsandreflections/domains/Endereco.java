package br.com.letscode.annotationsandreflections.domains;

import br.com.letscode.annotationsandreflections.annotations.Default;
import lombok.Data;

@Data
public class Endereco {

    private String bairro;
    private String cep;
    private String rua;
    @Default(value = "SN")
    private String numero;
}
