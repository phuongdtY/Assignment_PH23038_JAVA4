package Repository;

import DomainModel.ChiTietSanPham;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLChiTietSanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepository {
    private ArrayList<QLChiTietSanPham> list;
    private Session hSession;

    public ChiTietSanPhamRepository(){
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
        }

    public void insert(ChiTietSanPham ctsp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSanPham ctsp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSanPham ctsp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChiTietSanPham findById(UUID id) {
        return this.hSession.find(ChiTietSanPham.class,id);
    }

    public List<ChiTietSanPham> finAll() {
        String hql = "SELECT ctspObj FROM ChiTietSanPham ctspObj";
        TypedQuery<ChiTietSanPham> query = this.hSession.createQuery(hql,ChiTietSanPham.class);
        return query.getResultList();
    }

    public ChiTietSanPham findByTen(String ten) {
        String hql = "SELECT ctspObj FROM ChiTietSanPham ctspObj WHERE ctspObj.sanPham.ten =: ten1 ";
        TypedQuery<ChiTietSanPham> query = this.hSession.createQuery(hql,ChiTietSanPham.class);
        query.setParameter("ten1",ten);
        return query.getSingleResult();
    }
}
