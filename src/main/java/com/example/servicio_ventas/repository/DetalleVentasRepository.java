package com.example.servicio_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.servicio_ventas.model.DetalleVentas;

public interface DetalleVentasRepository extends JpaRepository<DetalleVentas, Long> {}