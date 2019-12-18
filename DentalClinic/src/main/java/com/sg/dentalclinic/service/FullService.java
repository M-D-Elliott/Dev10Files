/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dentalclinic.service;

import com.sg.dentalclinic.models.Appointment;
import com.sg.dentalclinic.models.Customer;
import com.sg.dentalclinic.models.Professional;
import com.sg.dentalclinic.models.Specialty;
import java.time.LocalDate;
import java.util.List;


public interface FullService {
    public boolean makeAppointment(Appointment appoitment);

    public List<Appointment> searchAppointments(LocalDate date, Professional professional);

    public List<Appointment> searchAppointments(LocalDate date, Customer customer);

    public List<Professional> getAllProfessionals();

    public List<Customer> getAllCustomers();

    public void addCustomer(Customer customer);
}
