package dev.jmvg.web.conversor;

import dev.jmvg.model.Cargo;
import dev.jmvg.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {
    private CargoService cargoService;

    @Autowired
    public StringToCargoConversor(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @Override
    public Cargo convert(String cargoId) {
        if(cargoId.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(cargoId);
        return cargoService.buscarPorId(id);
    }
}
