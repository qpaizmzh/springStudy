package com.spring_hiber.dao.impl;

import com.spring_hiber.dao.BookShopDao;
import com.spring_hiber.exp.BookStockException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String hql = "select b.price from BookEntity b where b.isbn=?";
//        不再使用setString等方法，直接使用setParameter
        Query query = getSession().createQuery(hql).setParameter(0, isbn);
        return (Integer) query.uniqueResult();
    }

    @Override
    public void updateBookStock(String isbn) {
        String hql2 = "SELECT b.stock FROM BookEntity b WHERE b.isbn = ?";
        int stock = (int) getSession().createQuery(hql2).setParameter(0, isbn).uniqueResult();
        if (stock == 0) {
            throw new BookStockException("库存不足!");
        }

        String hql = "UPDATE BookEntity b SET b.stock = b.stock - 1 WHERE b.isbn = ?";
        getSession().createQuery(hql).setParameter(0, isbn).executeUpdate();
    }

    @Override
    public void updateUserAccount(String username, int price) {
        //验证余额是否足够
        String hql2 = "SELECT a.balance FROM AccountEntity a WHERE a.username = ?";
        int balance = (int) getSession().createQuery(hql2).setParameter(0, username).uniqueResult();
        if (balance < price) {
            throw new BookStockException("余额不足!");
        }

        String hql = "UPDATE AccountEntity a SET a.balance = a.balance - ? WHERE a.username = ?";
        getSession().createQuery(hql).setParameter(0, price).setParameter(1, username).executeUpdate();
    }
}
