package org.casjedcem.Farmshop.global;

import org.casjedcem.Farmshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
