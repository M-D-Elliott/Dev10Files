package Utils;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static final List<Object> randomize(List<Object> list){
        Collections.shuffle(list);
        return list;
    }
}
