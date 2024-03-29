package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.RolesDto;
import com.rymchaouch.gestion_de_stock.models.Roles;

public class RoleMapper {
    public static RolesDto toRolesDto(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleNom(roles.getRoleNom())
                .build();
    }

    public static Roles toRoles(RolesDto dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(dto.id());
        roles.setRoleNom(dto.roleNom());
        roles.setUtilisateur(UtilisateurMapper.toUtilisateur(dto.utilisateurDto()));
        return roles;
    }
}
