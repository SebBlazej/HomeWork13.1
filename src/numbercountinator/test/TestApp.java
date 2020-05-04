package numbercountinator.test;

import numbercountinator.app.ConsoleWriter;
import numbercountinator.app.FileParser;

import java.io.IOException;
import java.util.Map;

public class TestApp {

    public static void main(String[] args) {

        FileParser fileParser = new FileParser();
        ConsoleWriter consoleWriter = new ConsoleWriter();
        try {
            Map<Integer, Integer> numbersMap = fileParser.getNumbersMapFromFile("testFile.txt");
            consoleWriter.writeSortedResult(numbersMap);
        }catch(IOException ex){
            System.out.println("Błąd wczytania pliku");
        }

    }
}
