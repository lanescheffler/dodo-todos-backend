package net.yorksolutions.dodotodosbackend.dodotodosbackend;

//import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)


    private Long id;

    private String processId;

    private int orderNumber;

    private String promptu;

    //status
    private boolean pending;

    private boolean done;

    private String comments;

    public StageEntity() {};

    public StageEntity(Long id, String processId, int orderNumber, String promptu, boolean pending, boolean done, String comments) {
        this.id = id;
        this.processId = processId;
        this.orderNumber = orderNumber;
        this.promptu = promptu;
        this.pending = pending;
        this.done = done;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPromptu() {
        return promptu;
    }

    public void setPromptu(String promptu) {
        this.promptu = promptu;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
