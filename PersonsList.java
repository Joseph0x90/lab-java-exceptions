import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        if (!Pattern.matches("[A-Za-z]+ [A-Za-z]+", name)) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null; // or throw exception if person is not found
    }

    public Person clone(Person original, int newId) {
        return new Person(newId, original.getName(), original.getAge(), original.getOccupation());
    }

    public void writePersonToFile(Person person, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
