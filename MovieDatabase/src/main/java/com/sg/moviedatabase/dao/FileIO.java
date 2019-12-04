package com.sg.moviedatabase.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO implements IFileIO {
    @Override 
    public List<String> readFile(String fileName){
        try{
            return Files.readAllLines(Paths.get(fileName));
        } catch (NoSuchFileException ex){
//            System.out.println("File " + fileName + " not found.\nCannot read.");
        } catch(IOException ex){
            System.out.println(ex);
        }
        return new ArrayList<>();
    }
    
    @Override 
    public boolean writeFile(String fileName, List<String> lines){
        try{
            Files.write(Paths.get(fileName), lines);
            return true;
        } catch (NoSuchFileException ex){
            System.out.println("File " + fileName + " not found.\n Cannot write.");
        } catch(IOException ex){
            System.out.println(ex);
        }
        return false;
    }
}
