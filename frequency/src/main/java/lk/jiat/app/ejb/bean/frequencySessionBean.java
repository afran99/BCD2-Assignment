package lk.jiat.app.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.Frequency;
import lk.jiat.app.core.service.FrequencyService;

import java.util.List;

@Stateless
public class frequencySessionBean implements FrequencyService {

    @PersistenceContext
    private EntityManager em;
    @Override
    public Frequency getFrequencyById(int id) {
        return null;
    }

    @Override
    public Frequency getFrequencyByfrequency(String frString) {
        return null;
    }

    @Override
    public List<Frequency> getAllFrequencies() {
        return em.createNamedQuery("frequency.findAll", Frequency.class)
                .getResultList();
    }
}
