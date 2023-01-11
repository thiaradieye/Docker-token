package com.groupeisi.mapping;

import com.groupeisi.domain.AppUserDTO;
import com.groupeisi.entities.AppUser;
import org.mapstruct.Mapper;

@Mapper
public interface AppUserMapper {
    AppUserDTO toAppUser(AppUser appUserEntity);
    AppUser fromAppUserDTO(AppUserDTO appUser);
}
