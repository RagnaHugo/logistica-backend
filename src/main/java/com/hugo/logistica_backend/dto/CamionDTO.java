package com.hugo.logistica_backend.dto;

import java.util.List;

public record CamionDTO(
        Long id,
        String placa,
        String conductor,
        List<EnvioDTO> envios        // <-- Mira esto, usa EnvioDTO, no la Entidad Envio
) {
}
