package com.example.tuesdb.dtos;

import com.example.tuesdb.models.Groups;
import com.example.tuesdb.models.Permissions;

import java.util.Set;

public class UserInputDto {
    private String username;
    private String password;
    private String name;
    private Set<String> permissions;
    private Set<String> groups;

    public UserInputDto() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getGroups() {
        return groups;
    }

    public void setGroups(Set<String> groups) {
        this.groups = groups;
    }
}
