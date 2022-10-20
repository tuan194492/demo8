import com.example.demo8.dao.StudentDAO;
import com.example.demo8.model.Lop;
import com.example.demo8.model.SinhVien;
import com.example.demo8.util.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        SinhVien sinhVien = getSession().get(SinhVien.class, 1);
//        Session session = HibernateUtils.getSession();
//        Lop lop = session.get(Lop.class, 2);
//        System.out.println(lop.getLopTruong().getId());
//        System.out.println("Hello world");
//        session.close();
        StudentDAO studentDAO = new StudentDAO();
        List<SinhVien> list = studentDAO.getAllSinhVien();
        System.out.println(list);
    }
}