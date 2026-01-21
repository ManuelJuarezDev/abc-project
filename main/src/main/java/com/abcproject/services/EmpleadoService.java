package com.abcproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abcproject.models.Empleado;
import com.abcproject.repositories.EmpleadoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerActivos() {
        return empleadoRepository.findByActivoTrue();
    }

    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizar(Empleado empleado) {
        Empleado existente = obtenerPorId(empleado.getId());
        existente.setNombre(empleado.getNombre());
        existente.setApellidos(empleado.getApellidos());
        existente.setCorreo(empleado.getCorreo());
        existente.setArea(empleado.getArea());
        existente.setSueldo(empleado.getSueldo());
        return empleadoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Empleado empleado = obtenerPorId(id);
        empleado.setActivo(false);
        empleadoRepository.save(empleado);
    }
}
