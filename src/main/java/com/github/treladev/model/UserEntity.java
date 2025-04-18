package com.github.treladev.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)// pobiera role kiedy jest potrzebna tylko dlatego lazy mozna jeszcze eager to od razu pobierze
    @JoinTable(
            name = "user_roles", // Nazwa tabeli pośredniczącej
            joinColumns = @JoinColumn(name = "user_id"), // Klucz obcy do tabeli users
            inverseJoinColumns = @JoinColumn(name = "role_id") // Klucz obcy do tabeli roles
    )
    private Set<RoleEntity> roles = new HashSet<>();

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
