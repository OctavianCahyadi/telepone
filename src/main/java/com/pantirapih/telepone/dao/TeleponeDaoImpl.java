package com.pantirapih.telepone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pantirapih.telepone.entity.Telepone;

@Transactional
@Repository
public class TeleponeDaoImpl implements TeleponeDao{

    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public Telepone simpanTelepone(Telepone telepone) {
        entityManager.getEntityManagerFactory().getCache().evictAll();
        telepone = entityManager.merge(telepone);
        return telepone;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Telepone> getAllTelepone() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
        String hql = "FROM Telepone ORDER BY id";
		return (List<Telepone>) entityManager.createQuery(hql).getResultList();
    }
    
}
