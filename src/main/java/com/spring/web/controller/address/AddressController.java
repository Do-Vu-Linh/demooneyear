package com.spring.web.controller.address;

import com.spring.web.model.District;
import com.spring.web.model.Province;
import com.spring.web.service.IProvinceService;
import com.spring.web.service.impl.AddressService;
import com.spring.web.service.impl.DistrictService;
import com.spring.web.service.impl.WardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
    @RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private WardService wardService;

    private final AddressService addressService;

    @GetMapping("/province")
    public ResponseEntity<?> findAllProvince() {
        return new ResponseEntity<>(provinceService.findAll(), HttpStatus.OK) ;
    }
    @GetMapping("/district/{id}")
    public ResponseEntity<?> findAllDistrictByProvince(@PathVariable("id") Long id) {
       Province province = provinceService.findById(id).get();
     return new ResponseEntity<>(districtService.findAllDistrictByProvince(province),HttpStatus.OK);
    }
    @GetMapping("/ward/{id}")
    public ResponseEntity<?> findAllWardByDistrict(@PathVariable("id") Long id) {
       District district = districtService.findById(id).get();
     return new ResponseEntity<>(wardService.findAllWardByDistrict(district),HttpStatus.OK);
    }

    @GetMapping("/address/test-exception/{id}")
    public ResponseEntity<?> findAddressById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(addressService.findByIdActual(id),HttpStatus.OK);
    }
}
