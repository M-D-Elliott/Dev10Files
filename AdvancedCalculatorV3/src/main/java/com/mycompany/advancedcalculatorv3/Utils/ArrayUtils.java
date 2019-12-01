package com.mycompany.advancedcalculatorv3.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ArrayUtils {
    private ArrayUtils() {}
    
    public static final int[] toIntArray(String[] array){
        int[] ret = new int[array.length];
        int i = 0;
        for (String string : array) {
            ret[i] = IntUtils.tryParseInt(string);
            i++;
        }
        return ret;
    }
    
    public static final <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    
    public static final Object[] randomize(Object[] array){
        List<Object> list = Arrays.asList(array);
 
        Collections.shuffle(list);
        return list.toArray();
    }
}
