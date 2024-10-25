package com.example.servicio_ventas.productosService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "producto-service", url = "http://localhost:8081")
public interface ProductoClient {
    @PutMapping("/productos/{id}/reducirStock")
    void reducirStock(@PathVariable("id") Long id, @RequestParam("cantidad") int cantidad);
}
