package cn.pku.meizi.controller;

import cn.pku.meizi.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.pku.meizi.enumer.*;

/**
 * Created by sunbo on 16/5/29.
 */
public class test {
    public static void main(String[] args){
        Configuration conf=new Configuration().configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf=conf.buildSessionFactory(serviceRegistry);
        Session sess=sf.openSession();
        Transaction ts=sess.beginTransaction();
        ts.commit();
        sess.close();
    }

}
