package com.spring.web.service;

import com.spring.web.model.Address;

public interface IAddressService extends CRUDService<Address , Long>{
    Address findByIdActual(Long aLong);

    Address findByIdActual2(Long aLong);
}
