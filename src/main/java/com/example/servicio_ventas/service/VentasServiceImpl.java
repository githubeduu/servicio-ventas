package com.example.servicio_ventas.service;


import com.example.servicio_ventas.Dto.ProductoVentaDTO;
import com.example.servicio_ventas.model.DetalleVentas;
import com.example.servicio_ventas.model.Ventas;
import com.example.servicio_ventas.productosService.ProductoClient;
import com.example.servicio_ventas.repository.DetalleVentasRepository;
import com.example.servicio_ventas.repository.VentasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private DetalleVentasRepository detalleVentasRepository;

    @Autowired
    private ProductoClient productoClient;

    @Override
    @Transactional
    public Ventas registrarVenta(Long usuarioId, List<ProductoVentaDTO> productos) {
        // Calcular el total de la venta
        double total = productos.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();

        // Crear una nueva venta
        Ventas venta = new Ventas();
        venta.setUsuarioId(usuarioId);
        venta.setTotal(total);
        venta.setFecha(LocalDateTime.now());
        ventasRepository.save(venta);

        productos.forEach(producto -> {
            DetalleVentas detalle = new DetalleVentas();
            detalle.setVentas(venta);
            detalle.setProductoId(producto.getProductoId());
            detalle.setCantidad(producto.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());

            detalleVentasRepository.save(detalle);

            productoClient.reducirStock(producto.getProductoId(), producto.getCantidad());
        });

        return venta;
    }
}

