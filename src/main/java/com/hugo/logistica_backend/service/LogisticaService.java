package com.hugo.logistica_backend.service;

import com.hugo.logistica_backend.dto.CamionDTO;
import com.hugo.logistica_backend.exception.RecursoNoEncontradoException;
import com.hugo.logistica_backend.mapper.LogisticaMapper;
import com.hugo.logistica_backend.model.Camion;
import com.hugo.logistica_backend.repository.CamionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogisticaService {

    private final CamionRepository camionRepo; //
    private final LogisticaMapper mapper;      // <-- Inyectamos el Mapper


    public CamionDTO obtenerCamion(Long id){
        Camion camion = camionRepo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("No existe el camion indicado"));
        //magia del mapper
        return mapper.toCamionDTO(camion);
    }

    public CamionDTO crearCamion(CamionDTO request) {
        // 1. Convertir DTO (JSON) a Entidad (Java puro)
        Camion entidad = mapper.toCamionEntity(request);

        // 2. Guardar en BD (Aquí la entidad gana un ID)
        Camion entidadGuardada = camionRepo.save(entidad);

        // 3. Convertir la entidad guardada (con ID) a DTO de respuesta
        return mapper.toCamionDTO(entidadGuardada);
    }


    public List<CamionDTO> obtenerCamiones(){
        return mapper.toCamionDTO(camionRepo.findAll());
    }

}
