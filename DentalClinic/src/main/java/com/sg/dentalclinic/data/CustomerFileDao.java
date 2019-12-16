package com.sg.dentalclinic.data;

import com.sg.dentalclinic.models.Customer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerFileDao 
        extends FileDao<Customer>
        implements CustomerDao {

    public CustomerFileDao(String path) {
        super(path, 4, false);

    }
    
    @Override
    public List<Customer> findAll() {
        try {
            return read(this::mapToCustomer).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Customer find(int ID) {
        return findAll().stream()
            .filter(a -> a.getID() == ID)
            .findFirst()
            .orElse(null);
    }

    @Override
    public void add(Customer arg) throws StorageException {
        append(arg, this::mapToString);
    }

    @Override
    public boolean update(int ID, Customer arg) throws NotFoundException, StorageException {
        List<Customer> customers = findAll();

        Customer customer = customers.get(ID);
        if(customer == null){
            throw new NotFoundException("customer not found.");
        }
        
        customers.set(ID, customer);
        write(customers, this::mapToString);
        return true;
    }

    @Override
    public boolean delete(int ID) throws NotFoundException, StorageException {
        Customer customer = find(ID);
        if(customer == null){
            throw new NotFoundException("customer not found.");
        }
        List<Customer> customers = findAll();
        customers.remove(ID);
        
        write(customers, this::mapToString);
        
        return true;
    }
    
    private String mapToString(Customer customer) {
        return String.format("%s,%s,%s,%s",
                customer.getID(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getDateOfBirth()
        );
    }

    private Customer mapToCustomer(String[] tokens) {
        return new Customer(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                LocalDate.parse(tokens[3])
        );
    }
}
