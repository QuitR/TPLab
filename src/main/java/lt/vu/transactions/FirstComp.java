package lt.vu.transactions;

import lt.vu.extensibility.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import java.util.Date;

@Named
@RequestScoped
public class FirstComp {
    @Resource
    private TransactionSynchronizationRegistry tx;

    @Inject
    private SecondComp secondComp;

    @Inject
    private Farewell farewell;

    @PostConstruct
    private void postConstruct() {
        System.out.println(this + " born :)");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println(this + " about to die :(");
    }

    //---------------------------------
    @LoggingInvocation
    @Transactional(Transactional.TxType.REQUIRED)
    public String sayHello() {
        return toString() + String.format(" | %s | Tx: %s \n Second component: %s \n %s", new Date(), tx.getTransactionKey(), secondComp.sayHello(), farewell.say());
    }
}
