package com.sales.goods.electronic;

import com.sales.goods.Goods;
import com.sales.shop.Selling;

//TODO: finish
public class Laptop extends Electronic {
    private String nameModel;

    public Laptop(long price, String description,String nameModel) {
        super(price, description);
        this.nameModel=nameModel;
    }

    public String getNameModel() {
        return nameModel;
    }


}
