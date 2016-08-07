package cn.pku.meizi.service;

import cn.pku.meizi.enumer.Level;
import cn.pku.meizi.domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo on 16/6/2.
 */
@Service
public class UserServiceImp implements UserService {

    @Override
    public List<User> listAllUsers() {
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        List rl=session.createQuery("select u from User u").list();
        List<User> rs=new ArrayList<>(rl);
        tx.commit();
        session.close();
        return rs;

    }

    @Override
    public List<User> listUsersByLevel(Level level) {
        return null;
    }

    @Override
    public User getUserByID(Integer id) {
        Session sess= HibernateUtil.getSession();
        Transaction tx=sess.beginTransaction();
        List rl=sess.createQuery("select u from User u where u.id=:uid").setInteger("uid",id).list();
        User rs=(User) rl.get(0);
        tx.commit();
        sess.close();
        return rs;
    }

    @Override
    public void deleteById(Integer id){
        Session session =HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        //session.createQuery("delete from User where id=:uid").setInteger("uid",id).executeUpdate();
        User cur=(User) session.load(User.class,id);
        session.delete(cur);
        tx.commit();
        session.close();
    }

    @Override
    public boolean updateUser(User user){
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        User cur=(User) session.load(User.class,user.getId());
        //updata
        session.save(cur);
        tx.commit();
        session.close();
        return true;
    }


    @Override
    public User getUserByUsername(String username) {
        User rs=null;
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        List rl=session.createQuery("select u from User u where u.userName=:name").setString("name",username).list();
        if(rl.size()==1)
            rs=(User)rl.get(0);
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public User getUserByTel(String tel) {
        User rs=null;
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        List rl=session.createQuery("select u from User u where u.mobile=:uTel").setString("uTel",tel).list();
        if(rl.size()==1)
            rs=(User)rl.get(0);
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public User getUserByEmail(String email) {
        User rs=null;
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        List rl=session.createQuery("select u from User u where u.email=:uemail").setString("uemail",email).list();
        if(rl.size()==1)
            rs=(User)rl.get(0);
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public User getUserByNTE(String nameTelEmail){
        //the type of nameTelEmail, 0--userName  1--telephone  2--email
        int type=0;
        if(nameTelEmail.contains("@")) type=2;
        else if (TelphoneCheck.check(nameTelEmail)) type=1;
        User rs=null;
        switch (type){
            case 0:
                rs=getUserByUsername(nameTelEmail);
                break;
            case 1:
                rs=getUserByTel(nameTelEmail);
                break;
            case 2:
                rs=getUserByEmail(nameTelEmail);
                break;
        }
        return rs;
    }
}
