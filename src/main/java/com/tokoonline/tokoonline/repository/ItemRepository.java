/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokoonline.tokoonline.repository;

import com.tokoonline.tokoonline.entity.Item;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author ustadho
 */

public interface ItemRepository extends PagingAndSortingRepository<Item, Serializable>{
    
}
