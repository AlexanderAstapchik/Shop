package com.sales;

import com.sales.goods.Goods;
import com.sales.goods.electronic.Laptop;
import com.sales.goods.electronic.Smartphone;
import com.sales.goods.medical.Drug;
import com.sales.shop.online.EShop;
import com.sales.tax.Tax;

public class Main {

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(100,"Laptop1","ASER31");
        Laptop laptop2 = new Laptop(120,"Laptop2","ASUS32");
        Smartphone smartphone=new Smartphone(50,"Smartphone");
        EShop eShop = new EShop();
        eShop.addNewGoods(laptop1);
        eShop.addNewGoods(laptop2);
        eShop.addNewGoods (smartphone);
        eShop.buy(smartphone);

        System.out.println(Tax.calcDamagesDuringDestroy(eShop));

    }
}
