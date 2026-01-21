package com.abcproject.mappers;

import org.springframework.stereotype.Component;

import com.abcproject.dtos.EmpleadoDTO;
import com.abcproject.models.Empleado;

@Component
public class EmpleadoMapper {

    public Empleado toEntity(EmpleadoDTO dto) {
        if (dto == null) {
            return null;
        }
        return Empleado.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .apellidos(dto.apellidos())
                .correo(dto.correo())
                .area(dto.area())
                .sueldo(dto.sueldo())
                .activo(dto.activo())
                .build();
    }

    public EmpleadoDTO toDTO(Empleado entity) {
        if (entity == null) {
            return null;
        }
        return new EmpleadoDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getApellidos(),
                entity.getCorreo(),
                entity.getArea(),
                entity.getSueldo(),
                entity.getActivo()
        );
    }
}
