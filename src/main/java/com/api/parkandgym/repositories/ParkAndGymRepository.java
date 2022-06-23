package com.api.parkandgym.repositories;

import com.api.parkandgym.models.ParkAndGymModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkAndGymRepository extends JpaRepository<ParkAndGymModel, UUID> {

    boolean existsByRegisterChildren(String registerChildren);
    boolean existsByRegisterResponsibleChildren(String registerResponsibleChildren);


}
