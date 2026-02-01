package com.hugo.logistica_backend.controller;

import com.hugo.logistica_backend.dto.CamionDTO;
import com.hugo.logistica_backend.service.LogisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logistica")
@RequiredArgsConstructor // Inyecta el Service automáticamente
public class LogisticaController {

    private final LogisticaService service;

    // 1. POST: Crear un Camión (Sin ID, sin envíos)
    // Recibe: { "placa": "ABC-123", "conductor": "Juan", "capacidadToneladas": 20.5 }
    // Devuelve: { "id": 1, "placa": "ABC-123", ... }
    @PostMapping("/camiones")
    public ResponseEntity<CamionDTO> crearCamion(@RequestBody CamionDTO request) {
        CamionDTO nuevoCamion = service.crearCamion(request);
        return new ResponseEntity<>(nuevoCamion, HttpStatus.CREATED);
    }

    // 2. GET: Obtener un Camión por ID
    // Si existe: Devuelve JSON 200 OK
    // Si NO existe: El GlobalExceptionHandler captura el error y devuelve 404 JSON bonito
    @GetMapping("/camiones/{id}")
    public ResponseEntity<CamionDTO> obtenerCamion(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerCamion(id));
    }


    // (Opcional) 3. GET: Listar todos
    @GetMapping("/camiones")
    public ResponseEntity<List<CamionDTO>> listarTodos() {
        return ResponseEntity.ok(service.obtenerCamiones());
    }

}
