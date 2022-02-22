package com.ruptam.address.controller;

import com.ruptam.address.entity.Address;
import com.ruptam.address.model.AddressDTO;
import com.ruptam.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
@RefreshScope
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    @Value("${address.profileProp}")
    private String profileProp;

    @PostMapping(value = "/")
    public ResponseEntity<?> saveAddress(@RequestBody AddressDTO addressDTO) {
        Address address = addressService.saveAddress(addressDTO);
        if (address != null) {
            return new ResponseEntity<Address>(address, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Failed", HttpStatus.NO_CONTENT);

    }

    @GetMapping(value = "/")
    public Address getAddressById(@RequestParam("addressId") Long addressId) {
        Address address = addressService.getAddressById(addressId);
        // if (address != null) {
        //     return new ResponseEntity<Address>(address, HttpStatus.OK);
        // }
        // return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
        return address;
    }

    @GetMapping(value = "/profile")
    public String readProfile() {
        return profileProp;
    }
}
