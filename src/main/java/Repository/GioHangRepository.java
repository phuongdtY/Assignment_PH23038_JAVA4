package Repository;

import DomainModel.GioHang;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class GioHangRepository {
    private Session hSession;

    public GioHangRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(GioHang gh) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(GioHang gh) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(GioHang gh) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public GioHang findById(UUID id) {
        return this.hSession.find(GioHang.class, id);
    }

    public List<GioHang> findAll() {
        String hql = "SELECT ghObj FROM GioHang ghObj";
        TypedQuery<GioHang> query = this.hSession.createQuery(hql, GioHang.class);
        return query.getResultList();
    }

    public GioHang findByMa(String ma) {
        String hql = "SELECT ghObj FROM GioHang ghObj WHERE ghObj.ma =: ma";
        TypedQuery<GioHang> query = this.hSession.createQuery(hql, GioHang.class);
        query.setParameter("ma", ma);
        return query.getSingleResult();
    }
}
