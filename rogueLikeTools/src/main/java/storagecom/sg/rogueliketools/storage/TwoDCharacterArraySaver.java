package storagecom.sg.rogueliketools.storage;

import java.util.ArrayList;
import java.util.List;

public class TwoDCharacterArraySaver extends FileIO {
    
    private static final String DELIMITER = "::";

    public TwoDCharacterArraySaver() {
    }
    
    public char[][] load(String fileName) {
        List<String> file = readFile(fileName);
        return unmarshall(file);
    }
    
    public void write(char[][] array, String fileName) {
        writeFile(fileName, marshall(array));
    }

    private char[][] unmarshall(List<String> file) {
        char[][] returnCharArray;
        
        int verticalSize = file.size();
        
        if(verticalSize > 0){
            int horizontalSize = file.get(0).length();
            returnCharArray = new char[verticalSize][horizontalSize];
            for (int i = 0; i < verticalSize; i++) {
                for (int j = 0; j < horizontalSize; j++) {
                    returnCharArray[i][j] = file.get(i).charAt(j);
                }
            }
        }
        return new char[0][0];
    }

    private List<String> marshall(char[][] array) {
        List<String> marshalledChars = new ArrayList<>();
        
        for (char[] cs : array) {
            marshalledChars.add(new String(cs));
        }
        return marshalledChars;
    }
}
