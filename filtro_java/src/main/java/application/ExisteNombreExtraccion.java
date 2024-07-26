package application;

import java.util.List;

import domain.service.NameExtraccionService;

public class ExisteNombreExtraccion {
    private NameExtraccionService nameExtraccionService;

    public ExisteNombreExtraccion(NameExtraccionService nameExtraccionService) {
        this.nameExtraccionService = nameExtraccionService;
    }

    public List<String> executeExtrac() {
        return this.nameExtraccionService.extraerName();
    }
}
