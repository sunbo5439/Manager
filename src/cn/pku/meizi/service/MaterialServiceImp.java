package cn.pku.meizi.service;

import cn.pku.meizi.domain.Manager;
import cn.pku.meizi.domain.Material;
import cn.pku.meizi.domain.MaterialCheckInfoItem;
import cn.pku.meizi.domain.PageModel;
import cn.pku.meizi.enumer.VideoCheckStatus;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunbo on 16/7/7.
 */
@Service
public class MaterialServiceImp implements MaterialService {
    @Override
    public List<Material> getUnChecked() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        List rl = session.createQuery("select m from Material m where m.status=0").list();
        List<Material> rs = new ArrayList<>(rl);
        tx.commit();
        session.close();
        return rs;
    }
    @Override
    public void setStatus(Integer id, VideoCheckStatus videoCheckStatus, Manager manager,String remark){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //Material cur=(Material)session.load(Material.class,id);
        Material cur=(Material)session.get(Material.class,id);
        cur.setStatus(videoCheckStatus);
        MaterialCheckInfoItem materialCheckInfoItem =new MaterialCheckInfoItem(manager.getId(),new Date(),videoCheckStatus,remark);
        cur.getCheckInfo().add(materialCheckInfoItem);
        session.save(cur);
        tx.commit();
        session.close();
    }

    @Override
    public String getURLByID(Integer id) {
        String rs;
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Material cur=(Material)session.load(Material.class,id);
        rs=new String(cur.getFile_uri());
        tx.commit();
        session.close();
        return rs;

    }

    @Override
    public Material getByID(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Material cur=(Material)session.get(Material.class,id);
        tx.commit();
        session.close();
        return cur;
    }

    @Override
    public List<Material> getLegalMedia() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        List rl = session.createQuery("select m from Material m where m.status=1").list();
        List<Material> rs = new ArrayList<>(rl);
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public List<Material> getIllegalMedia() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        List rl = session.createQuery("select m from Material m where m.status=2").list();
        List<Material> rs = new ArrayList<>(rl);
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public List<Material> getMediaByStatus(VideoCheckStatus videoCheckStatus) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        List rl = session.createQuery("select m from Material m where m.status=:x").setInteger("x",videoCheckStatus.ordinal()).list();
        List<Material> rs = new ArrayList<>(rl);
        tx.commit();
        session.close();
        return rs;
    }

    @Override
    public PageModel getPageModel(Integer currentPage, Integer rows,Integer status) {
        int totals = getAllCount(status);
        List<Material> datas = getAll(currentPage, rows,status);
        return new PageModel(totals, datas, rows, currentPage);
    }
    public int getAllCount(Integer status) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        long countAll = (long)HibernateUtil.getSession()
                .createQuery("select count(*) from Material m where m.status=:x ").setInteger("x",status)
                .uniqueResult();
        return (int)countAll;
    }

    public List<Material> getAll(int currPage, int pageSize, Integer status){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select m from Material m where m.status=:x").setInteger("x",status);
        query.setFirstResult(currPage*pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

}
