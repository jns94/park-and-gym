package com.api.parkandgym.controller;

import com.api.parkandgym.dtos.ParkAndGymDto;
import com.api.parkandgym.models.ParkAndGymModel;
import com.api.parkandgym.services.ParkAndGymService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/park-and-gym")
public class ParkAndGymController {

    final ParkAndGymService parkAndGymService;

    public ParkAndGymController(ParkAndGymService parkAndGymService) {
        this.parkAndGymService = parkAndGymService;
    }

    @PostMapping
    public ResponseEntity<Object> saveActivityChildren(@RequestBody @Valid ParkAndGymDto parkAndGymDto){
        if(parkAndGymService.existsByRegisterChildren(parkAndGymDto.getRegisterChildren())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Register Children is already in use!");
        }
        if (parkAndGymService.existsByRegisterResponsibleChildren(parkAndGymDto.getRegisterResponsibleChildren())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Register Responsible Children is already in use!");
        }
        var parkAndGymModel = new ParkAndGymModel();
        BeanUtils.copyProperties(parkAndGymDto, parkAndGymModel);
        parkAndGymModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkAndGymService.save(parkAndGymModel));
    }
    @GetMapping
    public ResponseEntity<List<ParkAndGymModel>> getAllActivityChildren(){
        return ResponseEntity.status(HttpStatus.OK).body(parkAndGymService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneActivityChildren(@PathVariable(value = "id")UUID id){
        Optional<ParkAndGymModel> parkAndGymModelOptional = parkAndGymService.findById(id);
        if(!parkAndGymModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity Children not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkAndGymModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteActivityChildren(@PathVariable(value = "id")UUID id) {
        Optional<ParkAndGymModel> parkAndGymModelOptional = parkAndGymService.findById(id);
        if (!parkAndGymModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity Children not found!");
        }
        parkAndGymService.delete(parkAndGymModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Activity Children deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateActivityChildren(@PathVariable(value = "id")UUID id,
                                                         @RequestBody @Valid ParkAndGymDto parkAndGymDto) {
        Optional<ParkAndGymModel> parkAndGymModelOptional = parkAndGymService.findById(id);
        if (!parkAndGymModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity Children not found!");
        }
        var parkAndGymModel = new ParkAndGymModel();
        BeanUtils.copyProperties(parkAndGymDto, parkAndGymModel);
        parkAndGymModel.setId(parkAndGymModelOptional.get().getId());
        parkAndGymModel.setRegistrationDate(parkAndGymModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(parkAndGymService.save(parkAndGymModel));
    }

}
