package service;

import modelo.Fabricante;
import repositorio.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    @Autowired
    public FabricanteService(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    public Fabricante cadastrarFabricante(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }
}
