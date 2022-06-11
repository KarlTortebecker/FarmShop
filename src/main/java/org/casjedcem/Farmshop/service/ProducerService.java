package org.casjedcem.Farmshop.service;

import org.casjedcem.Farmshop.model.Producer;
import org.casjedcem.Farmshop.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {
    @Autowired
    ProducerRepository producerRepository;

    public List<Producer> getAllProducer() {
        return producerRepository.findAll();
    }

    public void addProducer(Producer producer) {
        producerRepository.saveAndFlush(producer);
    }

    public void removeProducerById(int id) {
        producerRepository.deleteById(id);
    }

    public Optional<Producer> getProducerById(int id) {
        return producerRepository.findById(id);
    }

}
