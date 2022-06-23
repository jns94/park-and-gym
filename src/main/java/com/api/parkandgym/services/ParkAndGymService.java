package com.api.parkandgym.services;

import com.api.parkandgym.models.ParkAndGymModel;
import com.api.parkandgym.repositories.ParkAndGymRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkAndGymService {

    final ParkAndGymRepository parkAndGymRepository;

    public ParkAndGymService(ParkAndGymRepository parkAndGymRepository) {
        this.parkAndGymRepository = parkAndGymRepository;
    }

    @Transactional
    public ParkAndGymModel save(ParkAndGymModel parkAndGymModel) {
        return parkAndGymRepository.save(parkAndGymModel);
    }

    public boolean existsByRegisterChildren(String registerChildren) {
        return parkAndGymRepository.existsByRegisterChildren(registerChildren);
    }

    public boolean existsByRegisterResponsibleChildren(String registerResponsibleChildren) {
        return parkAndGymRepository.existsByRegisterResponsibleChildren(registerResponsibleChildren);
    }

    public List<ParkAndGymModel> findAll() {
        return parkAndGymRepository.findAll();
    }

    public Optional<ParkAndGymModel> findById(UUID id) {
        return parkAndGymRepository.findById(id);
    }

    @Transactional
    public void delete(ParkAndGymModel parkAndGymModel) {
        parkAndGymRepository.delete(parkAndGymModel);
    }
}
