package com.example.servicio_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.servicio_ventas.model.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long> {}
