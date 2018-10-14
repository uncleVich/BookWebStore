package webstore.repository;

import org.springframework.stereotype.Repository;
import webstore.domain.Customer;

import java.util.*;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("C1234", "Vasya", "Voronova", false);
        customers.add(customer1);

        return customers;
    }
}
