package net.yorksolutions.dodotodosbackend.dodotodosbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    String processStarted;

    public UserEntity() {};

    public UserEntity(String name, String processStarted) {
        this.name = name;
        this.processStarted = processStarted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessStarted() {
        return processStarted;
    }

    public void setProcessStarted(String processStarted) {
        this.processStarted = processStarted;
    }
}
