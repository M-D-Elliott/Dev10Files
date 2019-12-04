
package com.sg.moviedatabase.dao;

import java.util.List;

public interface IFileIO {
    boolean writeFile(String fileName, List<String> lines);
    
    List<String> readFile(String fileName);
}
