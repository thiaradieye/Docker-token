package com.groupeisi.controller;

import com.groupeisi.domain.AppRolesDTO;
import com.groupeisi.service.AppRolesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class AppRolesController {
   private AppRolesService appRolesService;

    @GetMapping
    public List<AppRolesDTO> getAppRoles() {
        return appRolesService.getAppRoles();
    }

    @GetMapping("{id}")
    public ResponseEntity<AppRolesDTO> getAppRoles(@PathVariable("id") int id) {

        return ResponseEntity.ok(appRolesService.getAppRoles(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)//si on insert il faut nous envoyer le status create-->200
    //@IsAdmin
    public AppRolesDTO createAppRoles(@Valid @RequestBody AppRolesDTO appRolesDTO) {
        return appRolesService.createAppRole(appRolesDTO);
    }

    @PutMapping("{id}")
    //@IsAdmin
    public AppRolesDTO updateAppRoles(@PathVariable("id") int id, @Valid @RequestBody AppRolesDTO appRolesDTO) {
        return appRolesService.updateAppRoles(id, appRolesDTO);
    }

    @DeleteMapping("{id}")
    public void deleteAppRoles(@PathVariable("id") int id) {
        appRolesService.deleteAppRoles(id);
    }
}
