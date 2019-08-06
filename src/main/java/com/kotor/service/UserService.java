package com.kotor.service;

import com.kotor.dao.CustomerRepository;
import com.kotor.public_api.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    private final CustomerRepository customerRepository;
    @Autowired
    private Theatre theatre;

    @Autowired
    public UserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String all() throws IOException {
        return theatre.sendRequest();
        //return theatre.generateJSON();
    }




}
