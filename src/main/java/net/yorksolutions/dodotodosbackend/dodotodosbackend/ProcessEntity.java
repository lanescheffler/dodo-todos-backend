package net.yorksolutions.dodotodosbackend.dodotodosbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProcessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String title;

    private boolean ifFinished;

    private boolean isStarted;

    public ProcessEntity() {};

    public ProcessEntity(Long id, String title, boolean ifFinished, boolean isStarted) {
        this.id = id;
        this.title = title;
        this.ifFinished = ifFinished;
        this.isStarted = isStarted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIfFinished() {
        return ifFinished;
    }

    public void setIfFinished(boolean ifFinished) {
        this.ifFinished = ifFinished;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }
}
