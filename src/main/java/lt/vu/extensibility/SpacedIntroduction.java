package lt.vu.extensibility;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
@ApplicationScoped
public class SpacedIntroduction implements iIntroduction {
    @Inject
    @Delegate
    @Any
    iIntroduction introduction;

    public String getIntroduction(String name) {
        return "\n" + introduction.getIntroduction(name) + "\n";
    }
}
