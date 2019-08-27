package dev.jmvg.web.validator;

import dev.jmvg.model.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class FuncionarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {

        return Funcionario.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Funcionario f = (Funcionario) object;
        LocalDate entrada = f.getDataEntrada();
        LocalDate saida = f.getDataSaida();
        if(saida != null){
            if(saida.isBefore(entrada)){
                errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
            }
        }
     }
}
