import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testSetAgeThrowsError() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });
    }

    @Test
    public void testFindByName() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 25, "Engineer");
        Person person2 = new Person(2, "Jane Smith", 30, "Doctor");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        assertEquals(person1, personsList.findByName("John Doe"));
        assertEquals(person2, personsList.findByName("Jane Smith"));
    }

    @Test
    public void testFindByNameThrowsException() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "John Doe", 25, "Engineer");
        personsList.addPerson(person);

        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("JohnDoe");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("John123 Doe");
        });
    }

    @Test
    public void testCloneMethod() {
        PersonsList personsList = new PersonsList();
        Person original = new Person(1, "John Doe", 25, "Engineer");
        personsList.addPerson(original);

        Person cloned = personsList.clone(original, 2);
        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());
    }
}
