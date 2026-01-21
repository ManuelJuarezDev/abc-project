package com.abcproject.dtos;

import java.math.BigDecimal;

public record EmpleadoDTO(
        Long id,
        String nombre,
        String apellidos,
        String correo,
        String area,
        BigDecimal sueldo,
        Boolean activo
        ) {

}
