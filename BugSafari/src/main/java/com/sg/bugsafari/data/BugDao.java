package com.sg.bugsafari.data;

import com.sg.bugsafari.models.Bug;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BugDao implements IBugDao {
    
    private static final String FILE_PATH = "bugs";
    
    private static final String DELIMITER = "::";
    
    @Override
    public Bug create(Bug bug) throws DataException{
        List<Bug> all = findAll();
        int newBugId = 0;
        for (Bug b : all) {
            newBugId = Math.max(newBugId, b.getId());
        }
        bug.setId(newBugId + 1);
        
        save(all);
        
        all.add(bug);
        return bug;
    }
    
    @Override
    public boolean update(Bug bug) throws DataException{
        return true;
    }
    
    @Override
    public boolean delete(int bugId){
        return true;
    }
    
    @Override
    public Bug getById(int bugId){
        return null;
    }
    
    @Override
    public List<Bug> findAll() throws DataException {
        ArrayList<Bug> all = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = null;
            while((line = reader.readLine()) != null){
                Bug bug = unmarshall(line);
                if(bug != null){
                    all.add(bug);
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("File not found!");
        } catch (IOException ex) {
            throw new DataException(ex.getMessage(), ex);
        }
        
        return all;
    }
    
    private void save(List<Bug> bugs) throws DataException {
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))){
            bugs.forEach((b) -> {
                writer.println(marshall(b));
            });
        } catch (IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
    }
    
    private String marshall(Bug b){
        return b.getId() + DELIMITER + b.getCommonName() + DELIMITER + b.getLatinName();
    }
    
    private Bug unmarshall(String line){
        String[] tokens = line.split(DELIMITER);
        if(tokens.length != 3) {
            return null;
        }
        
        Bug bug = new Bug();
        bug.setId(Integer.parseInt(tokens[0]));
        bug.setCommonName(tokens[1]);
        bug.setLatinName(tokens[2]);
        
        return bug;
    }

    @Override
    public Bug findById(int bugId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
