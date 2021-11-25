package com.pblgllgs.springbootservicioitem.service;

import com.pblgllgs.springbootservicioitem.model.Item;

import java.util.List;

public interface IItemService {
    public List<Item>findAll();
    public Item findById(Long id, Integer cantidad);
}
