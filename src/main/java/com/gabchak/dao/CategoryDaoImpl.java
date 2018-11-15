package com.gabchak.dao;

import com.gabchak.model.Category;
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
        return sessionFactory.getCurrentSession().createNamedQuery("SELECT * FROM CATEGORIES", Category.class).list();
    }

    @Override
    public Category findById(Long id) {
        //TODO: realisation
        return null;
    }
}
