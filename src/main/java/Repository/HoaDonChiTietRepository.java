package Repository;

import DomainModel.HoaDonChiTiet;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class HoaDonChiTietRepository {
    private Session hSession;

    public HoaDonChiTietRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(HoaDonChiTiet hdct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(HoaDonChiTiet hdct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(HoaDonChiTiet hdct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public HoaDonChiTiet findByHdAndSp(String idhd, String idctsp) {
        String hql = "SELECT hdctObj FROM HoaDonChiTiet hdctObj " +
                "WHERE hdctObj.chiTietSpHoaDon.id =: idctsp AND hdctObj.hoaDon.id =: idhd";
        TypedQuery<HoaDonChiTiet> query = this.hSession.createQuery(hql,HoaDonChiTiet.class);
        query.setParameter("idctsp",idctsp);
        query.setParameter("idhd",idhd);
        return query.getSingleResult();
    }

    public List<HoaDonChiTiet> findAll() {
        String hql = "SELECT hdctObj FROM HoaDonChiTiet hdctObj";
        TypedQuery<HoaDonChiTiet> query = this.hSession.createQuery(hql,HoaDonChiTiet.class);
        return query.getResultList();
    }

}
