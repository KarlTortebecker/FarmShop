package org.casjedcem.Farmshop.service;

import org.casjedcem.Farmshop.model.Enduser;
import org.casjedcem.Farmshop.model.Producer;
import org.casjedcem.Farmshop.repository.EnduserRepository;
import org.casjedcem.Farmshop.repository.EnduserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnduserService {
    @Autowired
    EnduserRepository enduserRepository;

    public List<Enduser> getAllEnduser() {
        return enduserRepository.findAll();
    }

    public void removeEnduserById(Long id) {
        enduserRepository.deleteById(id);
    }

    public Optional<Enduser> getEnduserById(Long id) {
        return enduserRepository.findById(id);
    }

}
