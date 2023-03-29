package Repository;

import DomainModel.MauSac;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLMauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository() {
        hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSac ms) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac ms) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSac ms) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public MauSac findById(String id) {
        return this.hSession.find(MauSac.class,id);
    }

    public List<MauSac> findAll() {
        String hql = "SELECT mauSacObj from MauSac mauSacObj";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql,MauSac.class);
        return  query.getResultList();
    }

    public MauSac findByMa(String ma) {
        String hql = "SELECT mauSacObj from MauSac mauSacObj where mauSacObj.ma =:ma1";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql,MauSac.class);
        query.setParameter("ma1",ma);
        return  query.getSingleResult();
    }

}
