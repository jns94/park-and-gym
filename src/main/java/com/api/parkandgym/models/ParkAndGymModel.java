package com.api.parkandgym.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARK_AND_GYM")
public class ParkAndGymModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable= true, length = 70)
    private String nameChildren;
    @Column(nullable = false, unique = true, length = 10)
    private String registerChildren;
    @Column(nullable = false, length = 70)
    private String responsibleChildren;
    @Column(nullable = false, unique = true, length = 8)
    private String registerResponsibleChildren;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 20)
    private String chosenActivity;

    public String getChosenActivity() {
        return chosenActivity;
    }

    public void setChosenActivity(String chosenActivity) {
        this.chosenActivity = chosenActivity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameChildren() {
        return nameChildren;
    }

    public void setNameChildren(String nameChildren) {
        this.nameChildren = nameChildren;
    }

    public String getRegisterChildren() {
        return registerChildren;
    }

    public void setRegisterChildren(String registerChildren) {
        this.registerChildren = registerChildren;
    }

    public String getResponsibleChildren() {
        return responsibleChildren;
    }

    public void setResponsibleChildren(String responsibleChildren) {
        this.responsibleChildren = responsibleChildren;
    }

    public String getRegisterResponsibleChildren() {
        return registerResponsibleChildren;
    }

    public void setRegisterResponsibleChildren(String registerResponsibleChildren) {
        this.registerResponsibleChildren = registerResponsibleChildren;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
