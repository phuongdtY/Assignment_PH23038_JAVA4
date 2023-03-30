package Repository;

import DomainModel.DongSanPham;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLDongSP;

import java.util.ArrayList;
import java.util.List;

public class DongSpRepository {
    private Session hSession;

    public DongSpRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public void insert(DongSanPham dongSP) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(dongSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(DongSanPham dongSP) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(dongSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(DongSanPham dongSP) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(dongSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public DongSanPham findById(String id) {
        return this.hSession.find(DongSanPham.class,id);
    }

    public List<DongSanPham> findAll() {
        String hql = "SELECT DongSanPhamObj from DongSanPham DongSanPhamObj";
        TypedQuery<DongSanPham> query = this.hSession.createQuery(hql,DongSanPham.class);
        return query.getResultList();
    }

    public DongSanPham findByMa(String ma) {
        String hql = "SELECT DongSanPhamObj from DongSanPham DongSanPhamObj where DongSanPhamObj.ma =: ma1";
        TypedQuery<DongSanPham> query = this.hSession.createQuery(hql,DongSanPham.class);
        query.setParameter("ma1", ma);
        return query.getSingleResult();
    }

}
