package com.pblgllgs.springbootservicioitem.service;

import com.pblgllgs.springbootservicioitem.model.Item;
import com.pblgllgs.springbootservicioitem.model.Producto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Primary
@Service("serviceRestTemplate")
public class ItemServiceImpl implements IItemService{

    private final RestTemplate clienteRest;

    public ItemServiceImpl(RestTemplate clienteRest) {
        this.clienteRest = clienteRest;
    }

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(Objects.requireNonNull(clienteRest.getForObject("http://servicio-productos/producto/all", Producto[].class)));
        return productos.stream().map(
                producto -> new Item(producto,1))
                        .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String,String> pathVariables = new HashMap<String,String>();
        pathVariables.put("id",id.toString());
        Producto producto = Objects.requireNonNull(clienteRest.getForObject("http://servicio-productos/producto/ver/{id}", Producto.class,pathVariables));
        return new Item(producto, cantidad);
    }
}
