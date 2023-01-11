package com.groupeisi.mapping;

import com.groupeisi.domain.AppRolesDTO;
import com.groupeisi.entities.AppRoles;
import org.mapstruct.Mapper;

@Mapper
public interface AppRolesMapper {
    AppRolesDTO toAppRoles(AppRoles appRolesEntity);
    AppRoles fromAppRolesDTO(AppRolesDTO appRoles);
}
