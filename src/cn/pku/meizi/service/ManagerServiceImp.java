package cn.pku.meizi.service;

import cn.pku.meizi.domain.Manager;
import cn.pku.meizi.domain.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo on 16/5/26.
 */
@Service
public class ManagerServiceImp implements ManagerService {

    @Override
    public List<Role> getAllRoles() {
        Session sess= HibernateUtil.getSession();
        Transaction tx=sess.beginTransaction();
        List rl=sess.createQuery("select distinct r from Role r").list();
        List<Role> rs=new ArrayList<>(rl);
        tx.commit();
        sess.close();
        return rs;

    }

    @Override
    public List<Manager> getAllManager() {
        return null;
    }

    @Override
    public List<Manager> getManagerByName(String name){
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        List rs=session.createQuery("select m from Manager m where m.name=:name").setString("name",name).list();
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public Role getRoleByID(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Role role=(Role) session.get(Role.class,id);
        tx.commit();
        session.close();
        return role;
    }
}
