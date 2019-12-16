
package storagecom.sg.rogueliketools.storage;

import java.util.List;

public interface IFileIO {
    // writes a list of strings, lines, onto the file of
    // specified name.
    boolean writeFile(String fileName, List<String> lines);
    
    // returns a list of strings, lines, to the caller
    // based on file name.
    List<String> readFile(String fileName);
}
