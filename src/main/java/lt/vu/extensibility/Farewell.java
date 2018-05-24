package lt.vu.extensibility;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Farewell {
    public String say()
    {
        return "\nFarewell";
    }
}
