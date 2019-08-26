package dev.jmvg.web.conversor;

import dev.jmvg.model.Departamento;
import dev.jmvg.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {
    private final DepartamentoService service;

    @Autowired
    public StringToDepartamentoConverter(DepartamentoService service) {
        this.service = service;
    }

    @Override
    public Departamento convert(String s) {
        if(s.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(s);
        return service.buscarPorId(id);
    }
}
