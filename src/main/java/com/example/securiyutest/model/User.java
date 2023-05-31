package com.example.securiyutest.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_login")
public class User implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 4, max = 40)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 20, max = 60)
    @Column(length = 60, unique = true, nullable = false)
    private String password;

    private String name;

    private String lastName;

    private String email;

    @NotNull
    @Column(nullable = false)
    private Boolean activated = false;

    private String langKey;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}
    )
    private Set<Role> roles = new HashSet<>();

}
