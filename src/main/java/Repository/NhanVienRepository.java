package Repository;

import DomainModel.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLNhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private Session hSession;

    public NhanVienRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NhanVien nv) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NhanVien nv) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NhanVien nv) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhanVien findById(String id) {
        return this.hSession.find(NhanVien.class,id);
    }

    public List<NhanVien> findAll() {
        String hql = "SELECT nhanVienObj from NhanVien nhanVienObj";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql,NhanVien.class);
        return query.getResultList();
    }


    public NhanVien findByMa(String ma) {
        String hql = "SELECT nhanVienObj from NhanVien nhanVienObj where nhanVienObj.ma =:ma1";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql,NhanVien.class);
        query.setParameter("ma1",ma);
        return query.getSingleResult();
    }
}
