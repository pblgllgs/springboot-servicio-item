package com.pblgllgs.springbootservicioitem.clientes;

import com.pblgllgs.springbootservicioitem.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-productos",url = "localhost:8001")
public interface ProductoClienteRest {

    @GetMapping("/producto/all")
    public List<Producto> listar();

    @GetMapping("/producto/ver/{id}")
    public Producto detalle(@PathVariable Long id);

}
