package lt.vu.extensibility;

import javax.enterprise.inject.Alternative;

@Alternative
public class FarewellFormal extends Farewell {
    public String say()
    {
        return super.say() + ". \n Yours, Java.";
    }
}
