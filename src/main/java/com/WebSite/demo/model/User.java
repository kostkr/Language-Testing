package com.WebSite.demo.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * contain personal information about users
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @EqualsAndHashCode.Include
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name="name", unique = true)
    private String name;

    @EqualsAndHashCode.Include
    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="role")
    private String role;

    @Column(name="isAccountNonExpired")
    private boolean isAccountNonExpired;

    @Column(name="isAccountNonLocked")
    private boolean isAccountNonLocked;

    @Column(name="isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;

    @Column(name="isEnabled")
    private boolean isEnabled;
}
