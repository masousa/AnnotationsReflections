package br.com.letscode.annotationsandreflections.domains;

import br.com.letscode.annotationsandreflections.annotations.Default;
import br.com.letscode.annotationsandreflections.annotations.DefaultData;
import br.com.letscode.annotationsandreflections.annotations.Format;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Funcionario {
    private String nome;
    private String sobrenome;
    @Default(value = "SM")
    private String matricula;

    @Format
    private LocalDate dataNascimento;

    @DefaultData
    private LocalDate dataInicioTrabalho;
    @Format(pattern = "MM-dd-yyyy")
    public LocalDate getDataInicioTrabalho() {
        return dataInicioTrabalho;
    }


}
