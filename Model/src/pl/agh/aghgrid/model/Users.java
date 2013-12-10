package pl.agh.aghgrid.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "select o from Users o") })
@Table(name = "\"users\"")
public class Users implements Serializable {
    private static final long serialVersionUID = -3822314101388691285L;
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "username", nullable = false)
    private String username;
    @OneToMany(mappedBy = "users", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Tasks> tasksList;

    public Users() {
    }

    public Users(int id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public Tasks addTasks(Tasks tasks) {
        getTasksList().add(tasks);
        tasks.setUsers(this);
        return tasks;
    }

    public Tasks removeTasks(Tasks tasks) {
        getTasksList().remove(tasks);
        tasks.setUsers(null);
        return tasks;
    }
}
