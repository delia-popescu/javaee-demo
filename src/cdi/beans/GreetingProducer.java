package cdi.beans;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;

public class GreetingProducer {

    @Produces
    List<String> greetings(){
        List<String> greetings = new ArrayList<String>();
        greetings.add("Hey!");
        greetings.add("Howdy!");

        return greetings;
    }

    void clean(@Disposes List<String> greetings) {
        //some cleanup operations
    }
}
