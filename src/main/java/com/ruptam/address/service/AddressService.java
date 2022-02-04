package com.ruptam.address.service;

import java.util.Optional;

import com.ruptam.address.entity.Address;
import com.ruptam.address.model.AddressDTO;
import com.ruptam.address.repository.AddressRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepo addressRepo;

    public Address saveAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setPlace(addressDTO.getPlace());
        return addressRepo.save(address);
    }

    public Address getAddressById(Long id) {
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        return null;
    }

}
