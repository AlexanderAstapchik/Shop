package com.sales.shop.online;

import com.sales.goods.Goods;
import com.sales.goods.electronic.Electronic;
import com.sales.goods.electronic.Laptop;
import com.sales.goods.electronic.Smartphone;
import com.sales.goods.food.Apple;
import com.sales.goods.food.Bread;
import com.sales.shop.Selling;

//TODO finish electronics
public class EShop implements Selling {
    private static final int ARRAY_SIZE = 5;
    private final Electronic[] electronicStorage;
    private int currentIndexElectronic;
    private long commonSumma;

    public EShop() {
        electronicStorage = new Electronic[ARRAY_SIZE];
        currentIndexElectronic=0;
    }

    @Override
    public boolean addNewGoods(Goods goods) {
        boolean wasAdded = false;
        if (goods instanceof Laptop && currentIndexElectronic< ARRAY_SIZE) {
            electronicStorage[currentIndexElectronic++] = (Laptop) goods;
            wasAdded = true;
        }
        if (goods instanceof Smartphone && currentIndexElectronic< ARRAY_SIZE) {
            electronicStorage[currentIndexElectronic++] = (Smartphone) goods;
            wasAdded = true;
        }
        if (wasAdded) {
            commonSumma += goods.getPrice();
        }
        return wasAdded;
    }

    @Override
    public long commonPrice() {
        if (commonSumma != 0) {
            return commonSumma;
        }
        for (int i = 0; i < currentIndexElectronic; i++) {
            commonSumma += electronicStorage[i].getPrice();
        }
        return commonSumma;
    }

    @Override
    public void printGoodsDescription() {
        for (int i = 0; i < currentIndexElectronic; i++) {
            System.out.println(electronicStorage[i].getDescription());
        }
    }

    @Override
    public boolean buy(Goods goods) {
        boolean wasRemoved = false;
        if (goods instanceof Laptop) {
            int index = find(electronicStorage, currentIndexElectronic, goods);
            if (index < 0) {
                return false;
            }
            remove(electronicStorage, currentIndexElectronic, index);
            currentIndexElectronic--;
            wasRemoved = true;
        }
        if (goods instanceof Smartphone) {
            int index = find(electronicStorage, currentIndexElectronic, goods);
            if (index < 0) {
                return false;
            }
            remove(electronicStorage, currentIndexElectronic, index);
            currentIndexElectronic--;
            wasRemoved = true;
        }
        if (wasRemoved) {
            commonSumma -= goods.getPrice();
        }
        return wasRemoved;
    }


    private int find(Goods[] storage, int currentIndex, Goods goods) {
        for (int i = 0; i < currentIndex; i++) {
            if (storage[i].equals(goods)) {
                return i;
            }
        }
        return -1;
    }
    private void remove(Goods[] storage, int currentIndex, int index) {
        storage[index] = storage[currentIndex - 1];
        storage[currentIndex - 1] = null;
    }
}
