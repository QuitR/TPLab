package lt.vu.usecases.cdi.security;

import lombok.Getter;
import lt.vu.auth.AdministratorArbaKrantai;
import lt.vu.auth.UserLoggedInArbaRagai;
import lt.vu.extensibility.iIntroduction;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ExecutionException;

@Model
public class SecureBean {
    /*@Inject
    private iIntroduction introduction;*/
    @Getter
    private String result = "Press the button!!!";

    @UserLoggedInArbaRagai
    public void tikPrisijungusiems() {
        result = "Buvo iškviestas metodas skirtas tik prisijungusiems.";
    }

    @AdministratorArbaKrantai
    public void tikAdminams() {
        result = "Buvo iškviestas metodas skirtas tik adminams.";
    }
    /*public String sayIntroduction() throws ExecutionException, InterruptedException {
        return introduction.getIntroduction(result);
    }*/

}
