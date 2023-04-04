package Repository;

import DomainModel.HoaDon;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class HoaDonRepository {
    private Session hSession;

    public HoaDonRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(HoaDon hd) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(HoaDon hd) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(HoaDon hd) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public HoaDon findById(UUID id) {
        return this.hSession.find(HoaDon.class,id);
    }

    public List<HoaDon> findAll() {
        String hql = "SELECT hdObj FROM HoaDon hdObj";
        TypedQuery<HoaDon> query = this.hSession.createQuery(hql,HoaDon.class);
        return query.getResultList();
    }

    public HoaDon findByMa(String ma) {
        String hql = "SELECT hdObj FROM HoaDon hdObj WHERE hdObj.ma =: ma1";
        TypedQuery<HoaDon> query = this.hSession.createQuery(hql,HoaDon.class);
        query.setParameter("ma1",ma);
        return query.getSingleResult();
    }

}
