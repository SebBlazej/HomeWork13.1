package numbercountinator.app;

import java.util.*;

public class ConsoleWriter {

    public void writeSortedResult(Map<Integer, Integer> numbersMap){

        Object[] keysArray = numbersMap.keySet().toArray();

        Arrays.sort(keysArray);

        for(Object key: keysArray){
            System.out.println(key + " - liczba wystąpień: " + numbersMap.get(key));
        }
    }
}
