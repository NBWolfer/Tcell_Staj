package org.example.spring_framework;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByName(String name);
    Customer findBySurname(String surname);
    Customer findCustomerById(Integer id);
}
