package lk.jiat.app.core.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "frequency")
@NamedQueries({
        @NamedQuery(name = "frequency.findBtId", query = "select f from Frequency f where f.id=:id"),
        @NamedQuery(name = "frequency.findAll", query = "select f from Frequency f"),
        @NamedQuery(name = "frequency.findByFrequency", query = "select f from Frequency f where f.frequency =:frequency")
})
public class Frequency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String frequency;

    public Frequency() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
