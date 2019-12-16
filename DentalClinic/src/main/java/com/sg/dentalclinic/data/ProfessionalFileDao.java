package com.sg.dentalclinic.data;

import com.sg.dentalclinic.models.Professional;
import com.sg.dentalclinic.models.Specialty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessionalFileDao
        extends FileDao<Professional>
        implements ProfessionalDao {

    public ProfessionalFileDao(String path) {
        super(path, 5, false);

    }
    
    @Override
    public List<Professional> findAll() {
        try {
            return read(this::mapToProfessional).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Professional find(int ID) {
        return findAll().stream()
            .filter(a -> a.getID() == ID)
            .findFirst()
            .orElse(null);
    }

    @Override
    public void add(Professional arg) throws StorageException {
        append(arg, this::mapToString);
    }

    @Override
    public boolean update(int ID, Professional arg) throws NotFoundException, StorageException {
        List<Professional> professionals = findAll();

        Professional professional = professionals.get(ID);
        if(professional == null){
            throw new NotFoundException("professional not found.");
        }
        
        professionals.set(ID, professional);
        write(professionals, this::mapToString);
        return true;
    }

    @Override
    public boolean delete(int ID) throws NotFoundException, StorageException {
        Professional professional = find(ID);
        if(professional == null){
            throw new NotFoundException("professional not found.");
        }
        List<Professional> professionals = findAll();
        professionals.remove(ID);
        
        write(professionals, this::mapToString);
        
        return true;
    }
    
    private String mapToString(Professional professional) {
        return String.format("%s,%s,%s,%s, %s",
                professional.getID(),
                professional.getFirstName(),
                professional.getLastName(),
                professional.getSpecialty(),
                professional.getHourlyRate()
        );
    }

    private Professional mapToProfessional(String[] tokens) {
        return new Professional(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                Specialty.parseSpecialty(tokens[3]),
                new BigDecimal(tokens[4])
        );
    }
}
