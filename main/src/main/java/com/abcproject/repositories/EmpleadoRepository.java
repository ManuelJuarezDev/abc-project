package com.abcproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcproject.models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByActivoTrue();

    Optional<Empleado> findByIdAndActivoTrue(Long id);
}
