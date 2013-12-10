package pl.agh.aghgrid.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Tasks.findAll", query = "select o from Tasks o") })
@Table(name = "\"tasks\"")
public class Tasks implements Serializable {
    private static final long serialVersionUID = -6140527576133165174L;
    @Column(name = "answer")
    private String answer;
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "receivetime")
    private Timestamp receivetime;
    @Column(name = "request", nullable = false)
    private String request;
    @Column(name = "sendtime")
    private Timestamp sendtime;
    @Column(name = "workingtime")
    private long workingtime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public Tasks() {
    }

    public Tasks(String answer, int id, Timestamp receivetime, String request, Timestamp sendtime, Users users,
                 long workingtime) {
        this.answer = answer;
        this.id = id;
        this.receivetime = receivetime;
        this.request = request;
        this.sendtime = sendtime;
        this.users = users;
        this.workingtime = workingtime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Timestamp receivetime) {
        this.receivetime = receivetime;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }


    public long getWorkingtime() {
        return workingtime;
    }

    public void setWorkingtime(long workingtime) {
        this.workingtime = workingtime;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
