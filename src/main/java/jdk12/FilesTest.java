package jdk12;

import org.junit.Ignore;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FilesTest {

    @Ignore
    public void testFilesMismatch() throws IOException {
        FileWriter fileWriter = new FileWriter("tmp\\a.txt");
        fileWriter.write("a");
        fileWriter.write("b");
        fileWriter.write("c");
        fileWriter.close();

        FileWriter fileWriterB = new FileWriter("tmp\\b.txt");
        fileWriterB.write("a");
        fileWriterB.write("b");
        fileWriterB.write("c");
        fileWriterB.close();

        //return the first not match position
        assertThat(Files.mismatch(Path.of("tmp/a.txt"), Path.of("tmp/b.txt")), equalTo(-1));
    }

}
