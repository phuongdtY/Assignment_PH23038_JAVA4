package Repository;

import view_model.QLSanPham;

import java.util.ArrayList;

public class SanPhamRepository {
    private ArrayList<QLSanPham> list;

    public SanPhamRepository() {
        this.list = new ArrayList<>();
        list.add(new QLSanPham("SP01","Sản Phẩm 01"));
        list.add(new QLSanPham("SP02","Sản Phẩm 02"));
    }

    public void insert(QLSanPham sp) {
        this.list.add(sp);
    }

    public void update(QLSanPham sp) {
        for (int i = 0; i < this.list.size(); i++) {
            QLSanPham item = this.list.get(i);
            if (item.getMa().equals(sp.getMa())) {
                this.list.set(i,sp);
            }
        }
    }

    public void delete(QLSanPham sp) {
        for (int i = 0; i < this.list.size(); i++) {
            QLSanPham item = this.list.get(i);
            if (item.getMa().equals(sp.getMa())) {
                this.list.remove(i);
            }
        }
    }

    public ArrayList<QLSanPham> findAll() {
        return this.list;
    }

    public QLSanPham findByMa(String ma) {
        for (int i = 0; i < this.list.size(); i++) {
            QLSanPham item = this.list.get(i);
            if (item.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }
        return null;
    }

}
