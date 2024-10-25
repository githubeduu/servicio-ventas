package com.example.servicio_ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicio_ventas.Dto.ProductoVentaDTO;
import com.example.servicio_ventas.model.Ventas;
import com.example.servicio_ventas.service.VentasService;

@RestController
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    private VentasService ventaService;

    @PostMapping("/registrar")
    public ResponseEntity<Ventas> registrarVenta(@RequestParam Long usuarioId, @RequestBody List<ProductoVentaDTO> productos) {
        Ventas venta = ventaService.registrarVenta(usuarioId, productos);
        return ResponseEntity.ok(venta);
    }
}
