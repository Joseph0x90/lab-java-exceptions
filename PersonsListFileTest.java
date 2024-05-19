import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListFileTest {

    @Test
    public void testWritePersonToFile() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "John Doe", 25, "Engineer");
        String filePath = "person.txt";

        personsList.writePersonToFile(person, filePath);

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            assertEquals(person.toString(), content);
        } catch (IOException e) {
            fail("Failed to read the file");
        }

        // Cleanup the file after test
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
