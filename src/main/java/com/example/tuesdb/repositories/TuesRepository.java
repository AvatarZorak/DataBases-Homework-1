package com.example.tuesdb.repositories;

import com.example.tuesdb.dtos.GroupDtos.GroupOutputDto;
import com.example.tuesdb.dtos.PermissionDtos.PermissionOutputDto;
import com.example.tuesdb.dtos.UserDtos.UserInputDto;
import com.example.tuesdb.dtos.UserDtos.UserOutputDto;
import com.example.tuesdb.models.Groups;
import com.example.tuesdb.models.Permissions;
import com.example.tuesdb.models.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;

@org.springframework.stereotype.Repository
public class TuesRepository {
    private final EntityManager entityManager;

    public TuesRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<UserOutputDto> getAllUsers() {
        return this.entityManager.createQuery("select u from Users u", Users.class).getResultList().stream().map(UserOutputDto::new).toList();
    }

    @Transactional
    public UserOutputDto createUser(UserInputDto userInputDto) {
        Users newUser = new Users();

        newUser.setUsername(userInputDto.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(userInputDto.getPassword()));
        newUser.setName(userInputDto.getName());
        newUser.setPermissions(new HashSet<>());
        newUser.setGroups(new HashSet<>());

        for(String currentPermissionName : userInputDto.getPermissions()) {
            Permissions currentPermission = this.entityManager.createQuery("select p from Permissions p where label = :currentPermissionName", Permissions.class).setParameter("currentPermissionName", currentPermissionName).getSingleResult();

            newUser.getPermissions().add(currentPermission);
        }

        for(String currentGroupName : userInputDto.getGroups()) {
            Groups currentGroup = this.entityManager.createQuery("select g from Groups g where name = :currentGroupName", Groups.class).setParameter("currentGroupName", currentGroupName).getSingleResult();

            newUser.getGroups().add(currentGroup);
        }

        this.entityManager.persist(newUser);

        return new UserOutputDto(newUser);
    }

    public List<GroupOutputDto> getAllGroups() {
        return this.entityManager.createQuery("select g from Groups g", Groups.class).getResultList().stream().map(GroupOutputDto::new).toList();
    }

    public List<PermissionOutputDto> getAllPermissions() {
        return this.entityManager.createQuery("select p from Permissions p", Permissions.class).getResultList().stream().map(PermissionOutputDto::new).toList();
    }
}
