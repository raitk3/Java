package ee.taltech.iti0202.files.input;

import ee.taltech.iti0202.files.exception.FileReaderException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

@Override
public List<String> readTextFromFile(String filename) {
    List<String> lines = new ArrayList<>();
    Path path = Paths.get(filename);
    try (Scanner scanner = new Scanner(path)) {
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
    } catch (IOException e) {
        throw new FileReaderException("No such file", e);
    }
    return lines;
    }
}
