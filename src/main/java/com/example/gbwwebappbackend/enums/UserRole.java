package com.example.gbwwebappbackend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN(
            List.of(
                    UserPermission.USER_CREATE,
                    UserPermission.USER_UPDATE,
                    UserPermission.USER_DELETE,
                    UserPermission.USER_READ,
                    UserPermission.VACANCY_CREATE,
                    UserPermission.VACANCY_READ,
                    UserPermission.VACANCY_DELETE

            )
    );

    final List<UserPermission> permissions;
}
