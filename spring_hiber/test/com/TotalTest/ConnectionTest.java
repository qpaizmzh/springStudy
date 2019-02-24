package com.TotalTest;

import com.spring_hiber.service.BookShopService;
import com.spring_hiber.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class ConnectionTest {

    private ApplicationContext applicationContext;
    private BookShopService bookShopService;
    private Cashier cashier;


    {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopService = applicationContext.getBean(BookShopService.class);
        cashier = applicationContext.getBean(Cashier.class);
    }


    @Test
    public void Testcashier() {
        cashier.checkout("abc",Arrays.asList("1001","1002"));
    }

    @Test
    public void testoperate() {
        bookShopService.purchase("abc", "1001");
    }

    @Test
    public void testcon() {
        System.out.println(applicationContext.getBean("dataSource"));
    }
}
