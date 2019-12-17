package com.sg.dentalclinic.data;

import com.sg.dentalclinic.models.Appointment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentFileDao
        extends FileDao<Appointment>
        implements AppointmentDao {
    
    public AppointmentFileDao(String path) {
        super(path, 5, false);
        
        LocalDate now = LocalDate.now();
        this.path = path + now + ".txt";
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
        return String.format("%s,%s,%s,%s, %s",
                appointment.getID(),
                appointment.getCustomerID(),
                appointment.getProfessionalID(),
                appointment.getStartTime(),
                appointment.getEndTime()
        );
    }

    private Appointment mapToAppointment(String[] tokens) {
        return new Appointment(
                Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]),
                LocalDate.parse(tokens[3]),
                LocalDate.parse(tokens[4])
        );
    }
}
