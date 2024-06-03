package 注解;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonParser parser = new PersonParser();
        List<PersonAnnotation> persons = parser.getPersons();
        for (PersonAnnotation person : persons) {
            System.out.println(person.name() + ":" + person.age());
        }
    }

}
