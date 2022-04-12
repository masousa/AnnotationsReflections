package br.com.letscode.annotationsandreflections.domains;

import br.com.letscode.annotationsandreflections.annotations.Default;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Funcionario {
    private String nome;
    private String sobrenome;
    @Default(value = "SM")
    private String matricula;

    private LocalDate dataNascimento;
}
