package com.example.tuesdb.dtos.PermissionDtos;

import com.example.tuesdb.models.Groups;
import com.example.tuesdb.models.Permissions;

import java.util.Set;

public class PermissionOutputDto {
    private String label;
    private Set<Groups> groups;

    public PermissionOutputDto() {

    }

    public PermissionOutputDto(Permissions permission) {
        this.label = permission.getLabel();
        this.groups = permission.getGroups();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }
}
