package lk.jiat.app.core.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "accountType")
@NamedQueries({
        @NamedQuery(name = "AccountType.findById", query = "select a from AccountType a where a.id=:id"),
        @NamedQuery(name = "AccountType.findAl", query = "select a from AccountType a"),
        @NamedQuery(name = "AccountType.findByType", query = "select a from AccountType a where a.type=:type"),
})
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
