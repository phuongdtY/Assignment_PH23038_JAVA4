package Repository;

import view_model.QLNSX;

import java.util.ArrayList;

public class NsxRepository {
    private ArrayList<QLNSX> list;

    public NsxRepository() {
        this.list = new ArrayList<>();
        list.add(new QLNSX("us","Mỹ"));
        list.add(new QLNSX("vi","Việt Nam"));
    }

    public void insert(QLNSX nsx) {
        this.list.add(nsx);
    }

    public void update(QLNSX nsx) {
        for (int i = 0; i < this.list.size(); i++) {
            QLNSX item = this.list.get(i);
            if (item.getMa().equals(nsx.getMa())){
                this.list.set(i,nsx);
            }
        }
    }

    public void delete(QLNSX nsx) {
        for (int i = 0; i < this.list.size(); i++) {
            QLNSX item = this.list.get(i);
            if (item.getMa().equals(nsx.getMa())){
                this.list.remove(i);
            }
        }
    }

    public ArrayList<QLNSX> findAll() {
        return this.list;
    }

    public QLNSX findByMa(String ma) {
        for (int i = 0; i < this.list.size(); i++) {
            QLNSX item = this.list.get(i);
            if (item.getMa().equals(ma)){
                return this.list.get(i);
            }
        }
        return null;
    }

}
