package Repository;

import view_model.QLDongSP;

import java.util.ArrayList;

public class DongSpRepository {
    private ArrayList<QLDongSP> list;

    public DongSpRepository() {
        this.list = new ArrayList<>();
        this.list.add(new QLDongSP("A","Loại A"));
        this.list.add(new QLDongSP("B","Loại B"));
    }

    public void insert(QLDongSP dongSP) {
        this.list.add(dongSP);
    }

    public void update(QLDongSP dongSP) {
        for (int i = 0; i < this.list.size(); i++) {
            QLDongSP item = this.list.get(i);
            if (item.getMa().equals(dongSP.getMa())) {
                this.list.set(i,dongSP);
            }
        }
    }

    public void delete(QLDongSP dongSP) {
        for (int i = 0; i < this.list.size(); i++) {
            QLDongSP item = this.list.get(i);
            if (item.getMa().equals(dongSP.getMa())) {
                this.list.remove(i);
            }
        }
    }

    public ArrayList<QLDongSP> findAll() {
        return this.list;
    }

    public QLDongSP findByMa(String ma) {
        for (int i = 0; i < this.list.size(); i++) {
            QLDongSP item = this.list.get(i);
            if (item.getMa().equals(ma)) {
               return this.list.get(i);
            }
        }
        return null;
    }

}
