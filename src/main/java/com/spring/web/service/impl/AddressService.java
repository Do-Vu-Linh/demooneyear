package com.spring.web.service.impl;

import com.spring.web.exception.CustomException;
import com.spring.web.exception.ErrorCode;
import com.spring.web.model.Address;
import com.spring.web.repository.AddressRepository;
import com.spring.web.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository repository;
    @Override
    public Optional<Address> findById(Long aLong) {

        return repository.findById(aLong);
    }

    @Override
    public Address findByIdActual(Long aLong) {

        return repository.findById(aLong).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, ": AddressId doesn't exist"));
    }

    @Override
    public Address findByIdActual2(Long aLong) {

        Optional<Address> addressOpt = repository.findById(aLong);
        if(!addressOpt.isPresent()) {
            throw new CustomException(ErrorCode.NOT_FOUND, ": AddressId doesn't exist");
        }
        return addressOpt.get();
    }

    @Override
    public List<Address> findAll() {

       return repository.findAll();
    }

    @Override
    public Address save(Address address) {

        return repository.save(address);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }


}
