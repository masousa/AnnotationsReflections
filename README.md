# AnnotationsReflections

## Exercícios
  ### Primeira Atividade
    Tendo a anotação format criada
```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
// TODO (1) add target para método (METHOD)
public @interface Format {
    String pattern() default "dd/MM/yyyy";
}

```

- Permita que esta anotação também seja aplicada à métodos.
- Adicione as anotações de format nos métodos de get and set da classe funcionário, retirando dos atributos
- Modifique a classe ```GetFormattedDataService``` para que os padrões sejam aplicados nos retornos dos métodos executados.

  ### Segunda Atividade
- Crie a anotação ```DefaultData``` presente em tempo de execução e disponíveis somente para atributos
- Modifique a classe InstantiateService para modificar os valores dos atributos que tiverem esta anotação para uma data atual.
- Crie cenários de teste para validar a modificação realizada na classe de serviço
