package pl.agh.aghgrid.model;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "SessionEJB", mappedName = "AGHGrid-Model-SessionEJB")
public class SessionEJBBean implements SessionEJB, SessionEJBLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    public SessionEJBBean() {
    }


    public Users persistUsers(Users users) {
        em.persist(users);
        return users;
    }

    public Users mergeUsers(Users users) {
        return em.merge(users);
    }

    public void removeUsers(Users users) {
        users = em.find(Users.class, users.getId());
        em.remove(users);
    }

    /** <code>select o from Users o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersFindAll() {
        return em.createNamedQuery("Users.findAll", Users.class).getResultList();
    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public Tasks persistTasks(Tasks tasks) {
        em.persist(tasks);
        return tasks;
    }

    public Tasks mergeTasks(Tasks tasks) {
        return em.merge(tasks);
    }

    public void removeTasks(Tasks tasks) {
        tasks = em.find(Tasks.class, tasks.getId());
        em.remove(tasks);
    }

    /** <code>select o from Tasks o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Tasks> getTasksFindAll() {
        return em.createNamedQuery("Tasks.findAll", Tasks.class).getResultList();
    }
}
