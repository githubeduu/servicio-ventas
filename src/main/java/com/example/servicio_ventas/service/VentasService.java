package com.example.servicio_ventas.service;

import java.util.List;

import com.example.servicio_ventas.Dto.ProductoVentaDTO;
import com.example.servicio_ventas.model.Ventas;


public interface VentasService {
    Ventas registrarVenta(Long usuarioId, List<ProductoVentaDTO> productos);
}

