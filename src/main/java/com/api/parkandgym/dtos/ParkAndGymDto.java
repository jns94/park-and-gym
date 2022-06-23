package com.api.parkandgym.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkAndGymDto {

    @NotBlank
    private String nameChildren;
    @NotBlank
    @Size(max = 10)
    private String registerChildren;
    @NotBlank
    private String responsibleChildren;
    @NotBlank
    @Size(max = 8)
    private String registerResponsibleChildren;
    @NotBlank
    private String chosenActivity;

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

    public String getChosenActivity() {
        return chosenActivity;
    }

    public void setChosenActivity(String chosenActivity) {
        this.chosenActivity = chosenActivity;
    }
}
