package com.devcolibri.bean;

import com.devcolibri.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class UserBean {

    // Будет инициализирован контейнером Glassfish
    // unitName = "DEVMODE" - это имя persistence-unit
    // EntityManager дает возможность выполнять CRUD запросы в БД
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    // Добавляем User-а В базу данных
    public User add(User user){
        return em.merge(user);
    }

    // Получаем пользователя по id
    public User get(long id){
        return em.find(User.class, id);
    }

    // обновляем пользователя
    // если User которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(User user){
        add(user);
    }

    // удаляем User по id
    public void delete(long id){
        em.remove(get(id));
    }

    // Получаем все пользователей с БД
/*
    public List<User> getAll(){
        List<User> l = new ArrayList<User>();
        l.add(new User("A", "B", 8));
        return l;
    }
*/
    public List<User> getAll(){
        Query query = em.createNamedQuery("findAll");
        List<User> customers = query.getResultList();
//        TypedQuery<User> namedQuery = em.createNamedQuery("getAll123", User.class);
        return customers;
    }
}
