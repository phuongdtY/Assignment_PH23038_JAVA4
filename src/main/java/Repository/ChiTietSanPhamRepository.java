package Repository;

import view_model.QLChiTietSanPham;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {
    private ArrayList<QLChiTietSanPham> list;

    public ChiTietSanPhamRepository(){
        this.list = new ArrayList<>();
        list.add(new QLChiTietSanPham("PH001","product_1","vi","red","A","3","mới zin","15","150000","200000"));
        list.add(new QLChiTietSanPham("PH002","product_2","us","blue","B","2","mới zun","5","150000","300000"));
    }

    public void insert(QLChiTietSanPham ctsp) {
        this.list.add(ctsp);
    }

    public void update(QLChiTietSanPham ctsp) {
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSanPham item = this.list.get(i);
            if (item.getMa().equals(ctsp.getMa())){
                this.list.set(i,ctsp);
            }
        }
    }

    public void delete(QLChiTietSanPham ctsp) {
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSanPham item = this.list.get(i);
            if (item.getMa().equals(ctsp.getMa())){
                this.list.remove(i);
            }
        }
    }

    public ArrayList<QLChiTietSanPham> finAll() {
        return this.list;
    }

    public QLChiTietSanPham findByMa(String ma) {
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSanPham item = this.list.get(i);
            if (item.getMa().equals(ma)){
                return this.list.get(i);
            }
        }

        return null;
    }
}
