package com.groupeisi.service;

import com.groupeisi.dao.IAppRolesRepository;
import com.groupeisi.domain.AppRolesDTO;
import com.groupeisi.exception.EntityNotFoundException;
import com.groupeisi.exception.RequestException;

import com.groupeisi.mapping.AppRolesMapper;
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
public class AppRolesService {
    private IAppRolesRepository iAppRolesRepository;
   private AppRolesMapper appRolesMapper;
    MessageSource messageSource;




    @Transactional(readOnly = true)
    public List<AppRolesDTO> getAppRoles() {
     return StreamSupport.stream(iAppRolesRepository.findAll().spliterator(), false)
             .map(appRolesMapper::toAppRoles)
             .collect(Collectors.toList());
    }
    //si on veut recuperer un seul role
    @Transactional(readOnly = true)
    public AppRolesDTO getAppRoles(int id) {
        return appRolesMapper.toAppRoles(iAppRolesRepository.findById(id)
                .orElseThrow(() ->//on cherche si on trouve on retourn  sinon on vas simplement envoyer saa
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    //la partie insertion
    @Transactional
    public AppRolesDTO createAppRole(AppRolesDTO appRoles) {
        //ce qui est dans la parantese c pour l'insertion
        return appRolesMapper.toAppRoles(iAppRolesRepository.save(appRolesMapper.fromAppRolesDTO(appRoles)));
    }
   //la partie Modification
    @Transactional
    public AppRolesDTO updateAppRoles(int id, AppRolesDTO appRoles){
        return iAppRolesRepository.findById(id)
                .map(entity -> {
                    appRoles.setId(id);
                    return appRolesMapper.toAppRoles((iAppRolesRepository.save(appRolesMapper.fromAppRolesDTO(appRoles))));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("appRoles.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }
    //la partie suppression
    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("appRoels.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
