package Repository;

import DomainModel.GioHangChiTiet;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GioHangChiTietRopository {

    private Session hSession;

    public GioHangChiTietRopository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(GioHangChiTiet ghct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ghct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(GioHangChiTiet ghct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ghct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(GioHangChiTiet ghct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ghct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public GioHangChiTiet findIdGhAndIdSp(String idGh, String idSp) {
        String hql = "SELECT ghctObj FROM GioHangChiTiet ghctObj " +
                "WHERE ghctObj.chiTietSp.id =: idctsp AND ghctObj.gioHang.id =: idGh";
        TypedQuery<GioHangChiTiet> query = this.hSession.createQuery(hql, GioHangChiTiet.class);
        query.setParameter("idctsp",idSp);
        query.setParameter("idGh",idGh);
        return query.getSingleResult();
    }

    public List<GioHangChiTiet> findAll() {
        String hql = "SELECT ghctObj FROM GioHangChiTiet ghctObj";
        TypedQuery<GioHangChiTiet> query = this.hSession.createQuery(hql, GioHangChiTiet.class);
        return query.getResultList();
    }

}
