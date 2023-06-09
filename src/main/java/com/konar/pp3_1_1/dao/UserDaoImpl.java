package com.konar.pp3_1_1.dao;

import com.konar.pp3_1_1.entity.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("FROM User ", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        User userToBeUpdate = entityManager.find(User.class, user.getId());
        userToBeUpdate.setName(user.getName());
        userToBeUpdate.setLastName(user.getLastName());
        userToBeUpdate.setEmail(user.getEmail());
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}