package lk.jiat.web.ecomm;

import lk.jiat.web.ecomm.util.Encryption;
import lk.jiat.web.ecomm.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
//        HibernateUtil.getSessionFactory();
        String encrypt = Encryption.encrypt("1234");
        System.out.println(encrypt);
    }
}
