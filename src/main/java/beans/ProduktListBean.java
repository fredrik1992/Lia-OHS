package beans;

import java.util.ArrayList;
import java.util.List;

public class ProduktListBean {
    List <ProduktBean> allOrders = new ArrayList<>();

    public ProduktListBean() {

    }

    public List<ProduktBean> getAllOrders() {
        return allOrders;
    }

    public void addProduct(ProduktBean orderProduktBean) {
        allOrders.add(orderProduktBean);
    }
}
