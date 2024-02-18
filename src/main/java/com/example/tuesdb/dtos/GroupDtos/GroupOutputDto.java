package com.example.tuesdb.dtos.GroupDtos;

import com.example.tuesdb.models.Groups;
import com.example.tuesdb.models.Permissions;

import java.util.Set;

public class GroupOutputDto {
    private String name;
    private Set<Permissions> permissions;

    public GroupOutputDto() {

    }

    public GroupOutputDto(Groups group) {
        this.name = group.getName();
        this.permissions = group.getPermissions();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }
}
