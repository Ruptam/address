package com.ruptam.address.service;

import java.util.Optional;

import com.ruptam.address.entity.Address;
import com.ruptam.address.model.AddressDTO;
import com.ruptam.address.repository.AddressRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final Logger log = LoggerFactory.getLogger(AddressService.class);
    
    @Autowired
    private AddressRepo addressRepo;

    public Address saveAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setPlace(addressDTO.getPlace());
        return addressRepo.save(address);
    }

    public Address getAddressById(Long id) {
        log.info("Inside address Service -> "+ id);
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        return null;
    }

}
