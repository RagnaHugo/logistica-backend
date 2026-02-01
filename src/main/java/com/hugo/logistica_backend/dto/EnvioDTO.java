package com.hugo.logistica_backend.dto;

//Para evitar el error clásico de "Recursión Infinita" (Camión llama a Envío, Envío llama a Camión...), usamos DTOs.
public record EnvioDTO(
        Long id,
        String guia,
        String cliente
) {
}
