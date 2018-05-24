package lt.vu.extensibility;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Greeting{
    public String getGreeting(){
        return "A basic greeting";
    }
}
