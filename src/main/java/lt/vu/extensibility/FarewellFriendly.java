package lt.vu.extensibility;

import javax.enterprise.inject.Alternative;

@Alternative
public class FarewellFriendly extends Farewell {
    public String say(){
        return super.say() + ", friend!";
    }
}
