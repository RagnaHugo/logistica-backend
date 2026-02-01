package com.hugo.logistica_backend.mapper;

//nos ahorramos lineas de codigo

import com.hugo.logistica_backend.dto.CamionDTO;
import com.hugo.logistica_backend.dto.EnvioDTO;
import com.hugo.logistica_backend.model.Camion;
import com.hugo.logistica_backend.model.Envio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") //permite inyectarlo con @Autowired/RequiredArgsConstructor
public interface LogisticaMapper {

 //mapeo envio- envioDTO
    @Mapping(target = "guia", source = "guiaRemision")// Si los nombres son diferentes, lo especificas
    EnvioDTO toEnvioDTO(Envio envio);

    // Mapeo Camion -> CamionDTO
    // MapStruct es inteligente: detectará que Camion tiene una lista de Envios
    // y usará automáticamente el método 'toEnvioDTO' de arriba para convertirlos.
    CamionDTO toCamionDTO(Camion camion);

    // También puedes hacer DTO -> Entidad (para guardar)
    // 2. De Request a Entidad (Para el SAVE)
    // Ignoramos 'id' (se genera solo) y 'envios'
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "envios", ignore = true) // Al crear camión, ignoramos envíos por ahora
    Camion toCamionEntity(CamionDTO dto);


    List<CamionDTO> toCamionDTO(List<Camion> camiones);

}
