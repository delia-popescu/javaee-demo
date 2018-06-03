package cdi.beans;

@Fancy
public class FancyGreeting implements Greeting{

    @Override
    public void greet(String name) {
        System.out.println("Howdy " + name);
    }
}
