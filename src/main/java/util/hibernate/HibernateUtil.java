package util.hibernate;

import entity.Account;
import entity.Bank;
import entity.Transaction;
import entity.User;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Transaction.class);
        configuration.addAnnotatedClass(Bank.class);
        configuration.configure();
        return configuration.buildSessionFactory();
    }

}
