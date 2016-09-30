package be.ghostwritertje.dao;

import be.ghostwritertje.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUser(String username) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(new User());
            transaction.commit();
        } catch (ConstraintViolationException e) {
            transaction.rollback();
        }
    }
}
