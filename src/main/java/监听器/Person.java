package 监听器;

public class Person {
    private PersonListener personListener;
    public void eat(){
        personListener.eat(new Event(this));
    }
    public void run(){
        personListener.run(new Event(this));
    }
    public void registerListener(PersonListener personListener){
        this.personListener = personListener;
    }
}
