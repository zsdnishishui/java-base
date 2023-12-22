package enity;

public class StudentClone implements Cloneable {
    private String name;
    private String id;

    public StudentClone() {

    }

    public StudentClone(String name) {
        this.name = name;
    }

    @Override
    public StudentClone clone() throws CloneNotSupportedException {
        return (StudentClone) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
