package misti.java.files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileAdaptor {

    public String FileToString(String pathname) {
        StringBuilder fileContentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Path.of(pathname), StandardCharsets.UTF_8)) {
            stream.forEach(s -> fileContentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return fileContentBuilder.toString().toLowerCase();
    }

    public void StringToFile(String content, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
