package com.groupeisi.service;

import com.groupeisi.dao.IAppUserRepository;
import com.groupeisi.domain.AppUserDTO;
import com.groupeisi.exception.EntityNotFoundException;
import com.groupeisi.exception.RequestException;
import com.groupeisi.mapping.AppUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AppUserService {
    private IAppUserRepository iAppUserRepository;
    private AppUserMapper appUserMapper;
    MessageSource messageSource;




    @Transactional(readOnly = true)
    public List<AppUserDTO> getAppUser() {
        return StreamSupport.stream(iAppUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toAppUser)
                .collect(Collectors.toList());
    }
    //si on veut recuperer un seul role
    @Transactional(readOnly = true)
    public AppUserDTO getAppRoles(int id) {
        return appUserMapper.toAppUser(iAppUserRepository.findById(id)
                .orElseThrow(() ->//on cherche si on trouve on retourn  sinon on vas simplement envoyer saa
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    //la partie insertion
    @Transactional
    public AppUserDTO createAppRoleUser(AppUserDTO appUserDTO) {
        //ce qui est dans la parantese c pour l'insertion
        return appUserMapper.toAppUser(iAppUserRepository.save(appUserMapper.fromAppUserDTO(appUserDTO)));
    }
    //la partie Modification
    @Transactional
    public AppUserDTO updateAppUser(int id, AppUserDTO appUserDTO){
        return iAppUserRepository.findById(id)
                .map(entity -> {
                    appUserDTO.setId(id);
                    return appUserMapper.toAppUser((iAppUserRepository.save(appUserMapper.fromAppUserDTO(appUserDTO))));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("appUser.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }
    //la partie suppression
    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("appUser.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
