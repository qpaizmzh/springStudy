package com.spring_hiber.service.impl;

import com.spring_hiber.service.BookShopService;
import com.spring_hiber.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;

    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn :
                isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
