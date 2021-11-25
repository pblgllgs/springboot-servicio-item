package com.pblgllgs.springbootservicioitem.service;

import com.pblgllgs.springbootservicioitem.clientes.ProductoClienteRest;
import com.pblgllgs.springbootservicioitem.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServiceFeign implements  IItemService{

    private final ProductoClienteRest productoClienteRest;

    public ItemServiceFeign(ProductoClienteRest productoClienteRest) {
        this.productoClienteRest = productoClienteRest;
    }

    @Override
    public List<Item> findAll() {
        return productoClienteRest.listar().stream().map(
                        producto -> new Item(producto,1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new  Item(productoClienteRest.detalle(id),cantidad);
    }
}
