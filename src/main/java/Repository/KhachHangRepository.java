package Repository;

import DomainModel.KhachHang;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_model.QLKhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private ArrayList<QLKhachHang> list;
    private Session hSession;

    public KhachHangRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
        this.list = new ArrayList<>();
    }

    public void insert(KhachHang kh){

        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(KhachHang kh){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(KhachHang kh){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public KhachHang findById(String id) {
        return this.hSession.find(KhachHang.class,id);
    }

    public List<KhachHang> findAll(){
        String hql = "SELECT kh from KhachHang kh";
        TypedQuery<KhachHang> query =
                this.hSession.createQuery(hql,KhachHang.class);
        return query.getResultList();
    }

    public KhachHang findByMa(String ma)
    {
        String hql = "SELECT kh from KhachHang kh WHERE kh.ma =:ma1";
        TypedQuery<KhachHang> query =
                this.hSession.createQuery(hql,KhachHang.class);
        query.setParameter("ma1",ma);
        return query.getSingleResult();
    }

}
