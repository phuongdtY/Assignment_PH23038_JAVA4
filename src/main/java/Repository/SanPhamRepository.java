package Repository;

import DomainModel.SanPham;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLSanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private ArrayList<QLSanPham> list;
    private Session hSession;

    public SanPhamRepository() {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(SanPham sp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(SanPham sp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(SanPham sp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public SanPham findById(String id) {
        return this.hSession.find(SanPham.class,id);
    }

    public List<SanPham> findAll() {
        String hql = "SELECT spObj FROM SanPham spObj";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql, SanPham.class);
        return query.getResultList();
    }

    public SanPham findByMa(String ma) {
        String hql = "SELECT spObj FROM SanPham spObj WHERE spObj.ma =: ma1";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql, SanPham.class);
        query.setParameter("ma1",ma);
        return query.getSingleResult();
    }

}
