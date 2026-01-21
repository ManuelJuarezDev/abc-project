package com.abcproject.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcproject.dtos.EmpleadoDTO;
import com.abcproject.mappers.EmpleadoMapper;
import com.abcproject.models.Empleado;
import com.abcproject.services.EmpleadoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final EmpleadoMapper empleadoMapper;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> obtenerEmpleados() {
        var empleados = empleadoService.obtenerActivos().stream().map(empleadoMapper::toDTO).toList();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable Long id) {
        var empleado = empleadoService.obtenerPorId(id);
        var empleadoDTO = empleadoMapper.toDTO(empleado);
        return ResponseEntity.ok(empleadoDTO);
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> guardar(@RequestBody EmpleadoDTO empleado) {
        Empleado datosEmpleado = empleadoMapper.toEntity(empleado);
        Empleado nuevoEmpleado = empleadoService.guardar(datosEmpleado);
        EmpleadoDTO respuesta = empleadoMapper.toDTO(nuevoEmpleado);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizar(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        Empleado datosEmpleado = empleadoMapper.toEntity(empleadoDTO);
        datosEmpleado.setId(id);
        Empleado empleadoActualizado = empleadoService.actualizar(datosEmpleado);
        EmpleadoDTO respuesta = empleadoMapper.toDTO(empleadoActualizado);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
