package 注解;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PersonParser {

    public List<PersonAnnotation> getPersons() {
        List<PersonAnnotation> list = new ArrayList<>();
        try {
            Class<?> clazz = Class.forName("注解.PersonTest");
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PersonAnnotation.class)) {
                    PersonAnnotation person = method.getAnnotation(PersonAnnotation.class);
                    list.add(person);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
