/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokoonline.tokoonline.controller;

import com.tokoonline.tokoonline.entity.Item;
import com.tokoonline.tokoonline.entity.KategoriItem;
import com.tokoonline.tokoonline.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ustadho
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/item")
public class ItemResouce {
    @Autowired
    ItemRepository itemRepository;
    
    @GetMapping
    public Page<Item> findAll(Pageable pgbl){
        return itemRepository.findAll(pgbl);
    }
    
    @GetMapping(value = "all")
    public Iterable<Item> findAll(){
        return itemRepository.findAll();
    }
    @PostMapping
    public Item create(@RequestBody Item item){
        return itemRepository.save(item);
    }
    
    @PutMapping("{id}")
    public Item update(@PathVariable("id") Integer id, @RequestBody Item item){
        Item i = itemRepository.findOne(id);
//        if(i!=null){
            item.setId(i.getId());
//        }
        itemRepository.save(item);
        return item;
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        itemRepository.delete(id);
    }
}
