package Repository;

import DomainModel.NhaSanXuat;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NsxRepository {
    private ArrayList<NhaSanXuat> list;
    private Session hSession;

    public NsxRepository() {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NhaSanXuat nsx) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NhaSanXuat nsx) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NhaSanXuat nsx) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhaSanXuat findById(String id) {
        return this.hSession.find(NhaSanXuat.class, id);
    }

    public List<NhaSanXuat> findAll() {
        String hql = "SELECT nsxObj FROM NhaSanXuat nsxObj";
        TypedQuery<NhaSanXuat> query = this.hSession.createQuery(hql,NhaSanXuat.class);
        return query.getResultList();
    }

    public NhaSanXuat findByMa(String ma) {
        String hql = "SELECT nsxObj FROM NhaSanXuat nsxObj WHERE nsxObj.ma =: ma1";
        TypedQuery<NhaSanXuat> query = this.hSession.createQuery(hql,NhaSanXuat.class);
        query.setParameter("ma1", ma);
        return query.getSingleResult();
    }

}
