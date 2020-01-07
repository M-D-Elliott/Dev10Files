package algo;

import static java.nio.file.Files.lines;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CompressionSort {
    public List<Holder> compress(List<List<Character>> holders){
        int index = 0;
        List<Holder> compressed = new ArrayList<>();
        
        for (List<Character> line : holders) {
            for (Character character : line) {
                if(compressed.isEmpty()){
                    compressed.add(new Holder(character, 1));
                } else {
                    Holder currHolder = compressed.get(index);
                    if(currHolder.getValue() == character){
                        currHolder.setCount(currHolder.getCount() + 1);
                    } else {
                        index++;
                        compressed.add(new Holder(character, 1));
                    }
                }
            }
            index++;
            compressed.add(new Holder(null, 1));
        }
        
        return compressed;
    }
    
    public List<List<Character>>  decompress(List<Holder> holders){
        List<List<Character>> retArray = new ArrayList<List<Character>>();
        
        List<Character> thisLine = new ArrayList<>();
        
        for (Holder holder : holders) {
            if(holder.getValue() == null){
                retArray.add(thisLine);
                thisLine = new ArrayList<>();
            } else {
                for (int i = 0; i < holder.getCount(); i++) {
                    thisLine.add(holder.getValue());
                }
            }
        }
        
        return retArray;
    }
}
