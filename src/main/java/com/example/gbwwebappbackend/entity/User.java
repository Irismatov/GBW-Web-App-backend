package com.example.gbwwebappbackend.entity;


import com.example.gbwwebappbackend.enums.UserPermission;
import com.example.gbwwebappbackend.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    private String id;
    @Column(unique=true, nullable=false)
    private String username;
    private String password;

    @CreationTimestamp(source = SourceType.VM)
    private LocalDateTime createdAt;
    @UpdateTimestamp(source = SourceType.VM)
    private LocalDateTime updatedAt;
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString();
        isActive = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = role.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        return authorities;
    }
}
