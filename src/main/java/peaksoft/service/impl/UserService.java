package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import peaksoft.model.User;
import peaksoft.service.ModelService;

import java.util.List;

@Service
@Transactional
public class UserService implements ModelService<User> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void update(Long id, User user) {
        User oldUser = findById(id);
        oldUser.setName(user.getName());
        oldUser.setLastName(user.getLastName());
        oldUser.setAge(user.getAge());
        oldUser.setGender(user.getGender());
        entityManager.persist(oldUser);


    }

    @Override
    public void delateById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
