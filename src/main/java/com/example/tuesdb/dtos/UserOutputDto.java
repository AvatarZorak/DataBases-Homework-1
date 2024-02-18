package com.example.tuesdb.dtos;

import com.example.tuesdb.models.Groups;
import com.example.tuesdb.models.Permissions;
import com.example.tuesdb.models.Users;
import org.apache.catalina.User;

import java.util.Set;

public class UserOutputDto {
    private Long id;
    private String name;
    private Set<Permissions> permissions;
    private Set<Groups> groups;

    public UserOutputDto() {

    }

    public UserOutputDto(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.permissions = user.getPermissions();
        this.groups = user.getGroups();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }
}
