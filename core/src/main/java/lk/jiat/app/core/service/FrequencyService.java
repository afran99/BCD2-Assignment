package lk.jiat.app.core.service;

import jakarta.ejb.Remote;
import lk.jiat.app.core.model.Frequency;

import java.util.List;

@Remote
public interface FrequencyService {

    Frequency getFrequencyById(int id);
    Frequency getFrequencyByfrequency(String frString);
    List<Frequency> getAllFrequencies();

}
