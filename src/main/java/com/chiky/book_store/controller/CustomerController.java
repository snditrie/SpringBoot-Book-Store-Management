package com.chiky.book_store.controller;

import com.chiky.book_store.constant.APIUrl;
import com.chiky.book_store.entity.Customer;
import com.chiky.book_store.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.CUSTOMER_API)
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.create(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @GetMapping(path = APIUrl.PATH_VAR_ID)
    public ResponseEntity<Customer> showCustomerById(@PathVariable String id) {
        Customer customerFound = customerService.getById(id);
        return ResponseEntity.ok(customerFound);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> showAllCustomers() {
        List<Customer> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer customerToUpdate = customerService.update(customer);
        return ResponseEntity.ok(customerToUpdate);
    }
}
