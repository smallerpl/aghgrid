package pl.agh.aghgrid.model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface SessionEJB {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Users persistUsers(Users users);

    Users mergeUsers(Users users);

    void removeUsers(Users users);

    List<Users> getUsersFindAll();

    Tasks persistTasks(Tasks tasks);

    Tasks mergeTasks(Tasks tasks);

    void removeTasks(Tasks tasks);

    List<Tasks> getTasksFindAll();
}
