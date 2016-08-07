package cn.pku.meizi.service;

/**
 * Created by sunbo on 16/5/29.
 */
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    // ThreadLocal可以隔离多个线程的数据共享，因此不再需要对线程同步
    public static final ThreadLocal<Session> session
            = new ThreadLocal<Session>();

    public static Session currentSession()
            throws HibernateException
    {
        Session s = session.get();
        // 如果该线程还没有Session,则创建一个新的Session
        if (s == null)
        {
            s = ourSessionFactory.openSession();
            // 将获得的Session变量存储在ThreadLocal变量session里
            session.set(s);
        }
        return s;
    }

    public static void closeSession()
            throws HibernateException
    {
        Session s = session.get();
        if (s != null)
            s.close();
        session.set(null);
    }
}
