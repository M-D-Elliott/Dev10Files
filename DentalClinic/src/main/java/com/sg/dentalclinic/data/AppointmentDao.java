/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dentalclinic.data;

import com.sg.dentalclinic.models.Appointment;
import com.sg.dentalclinic.models.Customer;
import com.sg.dentalclinic.models.Professional;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Marcus
 */
public interface AppointmentDao extends Dao<Appointment>{
    
    public String getPath();

    public String getDate();
    
    public void setDate(String dateString);
}
