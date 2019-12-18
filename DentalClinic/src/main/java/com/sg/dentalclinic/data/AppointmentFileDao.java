package com.sg.dentalclinic.data;

import com.sg.dentalclinic.models.Appointment;
import com.sg.dentalclinic.models.Customer;
import com.sg.dentalclinic.models.Professional;
import com.sg.dentalclinic.models.Specialty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentFileDao
        extends FileDao<Appointment>
        implements AppointmentDao {
    
    private String dateString = "";
    
    public AppointmentFileDao(String path) {
        super(path, 7, true);
    }
    
    @Override
    public List<Appointment> findAll() {
        try {
            return read(this::mapToAppointment).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Appointment find(int ID) {
        return findAll().stream()
            .filter(a -> a.getID() == ID)
            .findFirst()
            .orElse(null);
    }

    @Override
    public void add(Appointment arg) throws StorageException {
        append(arg, this::mapToString);
    }

    @Override
    public boolean update(int ID, Appointment arg) throws NotFoundException, StorageException {
        List<Appointment> appointments = findAll();

        Appointment appointment = appointments.get(ID);
        if(appointment == null){
            throw new NotFoundException("Appointment not found.");
        }
        
        appointments.set(ID, appointment);
        write(appointments, this::mapToString);
        return true;
    }

    @Override
    public boolean delete(int ID) throws StorageException, NotFoundException {
        Appointment appointment = find(ID);
        if(appointment == null){
            throw new NotFoundException("Appointment not found.");
        }
        List<Appointment> appointments = findAll();
        appointments.remove(ID);
        
        write(appointments, this::mapToString);
        
        return true;
    }
    
    private String mapToString(Appointment appointment) {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                appointment.getCustomerID(),
                appointment.getProfessionalLastName(),
                appointment.getProfessionalSpecialty().getName(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getCostToCustomer(),
                appointment.getNotes()
        );
    }

    private Appointment mapToAppointment(String[] tokens) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
        return new Appointment(
                Integer.parseInt(tokens[0]),
                tokens[1],
                Specialty.fromName(tokens[2]),
                LocalTime.parse(tokens[3]),
                LocalTime.parse(tokens[4]),
                new BigDecimal(tokens[5]),
                tokens[6],
                LocalDate.parse(this.dateString)
        );
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getDate() {
        return dateString;
    }

    @Override
    public void setDate(String dateString) {
        this.dateString = dateString;
        this.path = "database/appointments_" + dateString.replace("-", "") + ".txt";
    }
}
