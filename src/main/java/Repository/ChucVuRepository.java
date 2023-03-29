package Repository;

import DomainModel.ChucVu;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.validation.constraints.Min;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLChucVu;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    private ArrayList<QLChucVu> list;
    private Session hSession;

    public ChucVuRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
        list = new ArrayList<>();

//        list.add(new QLChucVu("staff","nhân viên"));
//        list.add(new QLChucVu("manage","quản lý"));
    }

    public void insert(ChucVu cv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public  void update(ChucVu cv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public  void delete(ChucVu cv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChucVu findById(String id) {
        return this.hSession.find(ChucVu.class, id);
    }

    public List<ChucVu> findAll() {
        String hql = "SELECT cvObj from ChucVu cvObj";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findByMa(String ma) {
        String hql = "SELECT cvObj from ChucVu cvObj WHERE cvObj.ma = :ma1 ";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        query.setParameter("ma1",ma);
        return query.getSingleResult();
    }

}
