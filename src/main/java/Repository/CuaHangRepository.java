package Repository;

import DomainModel.CuaHang;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLCuaHang;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {
    private ArrayList<QLCuaHang> list;
    private Session hSession;
    public CuaHangRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
        this.list = new ArrayList<QLCuaHang>();
    }

    public void insert(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public CuaHang findById(String id) {
        return this.hSession.find(CuaHang.class,id);
    }

    public List<CuaHang> findAll() {
        String hql = "SELECT cuaHangObj from CuaHang cuaHangObj";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql,CuaHang.class);
        return query.getResultList();
    }

    public CuaHang findByMa(String ma) {
        String hql = "SELECT cuaHangObj from CuaHang cuaHangObj where cuaHangObj.ma =:ma1";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql,CuaHang.class);
        query.setParameter("ma1",ma);
        return query.getSingleResult();
    }

}
