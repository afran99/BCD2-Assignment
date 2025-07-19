package lk.jiat.app.core.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "accountType")
public class AccountType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    public AccountType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
