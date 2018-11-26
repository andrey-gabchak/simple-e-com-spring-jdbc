package com.gabchak.dao;

import com.gabchak.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT ID, CATEGORY_NAME FROM CATEGORIES",
                Category.class).list();
    }

    @Override
    public Category findById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from category c join fetch c.productList where c.id =:id", Category.class)
                .setParameter("ID", id)
                .uniqueResult();
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(currentSession.load(Category.class, id));
        currentSession.flush();
    }
}