package numbercountinator.app;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileParser {

    public Map<Integer, Integer> getNumbersMapFromFile(String fileName) throws IOException {
        Map<Integer, Integer> numbersMap = new LinkedHashMap<>();

        List<String> listOfLines = getSplitedFileContent(fileName);
        for(String nextLine: listOfLines){
            Integer nextLineNumber = Integer.parseInt(nextLine);
            addNextLineNumberToMap(numbersMap, nextLineNumber);
        }

        return numbersMap;
    }

    private void addNextLineNumberToMap(Map<Integer, Integer> numbersMap, Integer number) {
        if(!mapContainsNumberAsKey(numbersMap, number)){
            numbersMap.put(number, 1);
        }else{
            increaseNumberCounter(numbersMap, number);
        }
    }

    private void increaseNumberCounter(Map<Integer, Integer> numbersMap, Integer number) {
        Integer countValue = numbersMap.get(number);
        numbersMap.put(number, countValue+1);
    }

    private boolean mapContainsNumberAsKey(Map<Integer, Integer> numbersMap, Integer number){
        return numbersMap.containsKey(number);
    }


    private List<String> getSplitedFileContent(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        List<String> stringList = reader.lines().collect(Collectors.toList());
        reader.close();

        return stringList;
    }

}
