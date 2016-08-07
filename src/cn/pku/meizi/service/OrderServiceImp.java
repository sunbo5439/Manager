package cn.pku.meizi.service;

import cn.pku.meizi.domain.Order;
import cn.pku.meizi.domain.OrderItem;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo on 16/6/24.
 */
@Service
public class OrderServiceImp implements OrderService {
    @Override
    public List<Order> listAllOrders() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        List rl = session.createQuery("select u from Order u").list();
        List<Order> rs = new ArrayList<>(rl);
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public Order getOrderbyUUID(String uuid) {
        Session sess = HibernateUtil.getSession();
        Transaction tx = sess.beginTransaction();
        List rl = sess.createQuery("select u from Order u where u.uuid=:x_uuid").setString("x_uuid", uuid).list();
        if(rl.size()==0) return null;
        Order rs = (Order) rl.get(0);
        tx.commit();
        sess.close();
        return rs;
    }

    @Override
    public Order getOrderByID(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        //Order order=(Order) session.load(Order.class,id);
        Order order = (Order) session.createQuery("select o from Order o where o.id=:x_id").setInteger("x_id", id).uniqueResult();
        //Hibernate.initialize(order);
        tx.commit();
        session.close();
        return order;
    }

    @Override
    public void deleteByUUID(String uuid) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Order order=getOrderbyUUID(uuid);
        Hibernate.initialize(order);
        session.delete(order);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteByID(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Order order=(Order)session.load(Order.class,id);
        session.delete(order);
        tx.commit();
        session.close();
    }

    @Override
    public boolean updateOrder(Order order) {
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        //Order cur=getOrderbyUUID(order.getUuid());
        Order cur=(Order) session.get(Order.class,order.getId()) ;
        cur.update(order);
        //session.persist(order);
        session.save(cur);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public List<OrderItem> getOrderItembyOrderID(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Order curOrder=getOrderByID(id);
        List rl= session.createQuery("from OrderItem as oi where oi.order=(from Order o where o.id=:x)").setInteger("x",id).list();
        List<OrderItem> rs=new ArrayList<>(rl);
        return rs;

    }
}
