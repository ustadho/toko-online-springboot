/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokoonline.tokoonline.controller;

import com.tokoonline.tokoonline.entity.Penjualan;
import com.tokoonline.tokoonline.entity.PenjualanDetail;
import com.tokoonline.tokoonline.repository.PenjualanRepository;
import com.tokoonline.tokoonline.repository.PenjualanRepository;
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
@RequestMapping("api/penjualan")
public class PenjualanResouce {

    @Autowired
    PenjualanRepository repository;

    @GetMapping
    public Page<Penjualan> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    @PostMapping
    public Penjualan create(@RequestBody Penjualan p) {
        for (PenjualanDetail d : p.getDetail()) {
            d.setPenjualan(p);
        }
        return repository.save(p);
    }

    @PutMapping("{id}")
    public Penjualan update(@PathVariable("id") Integer id, @RequestBody Penjualan p) {
        Penjualan i = repository.findOne(id);
//        if(i!=null){
        p.setId(i.getId());
//        }
        for (PenjualanDetail d : p.getDetail()) {
            d.setPenjualan(p);
        }
        repository.save(p);
        return p;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }
}
