package lt.vu.extensibility;

import javax.enterprise.inject.Specializes;

@Specializes
public class GreetingStandard extends Greeting{
    public String getGreeting(){
        return "Hello, world!";
    }
}
