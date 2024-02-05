package com.dakar.DakarApi.controller;


import com.dakar.DakarApi.controller.dto.BikeDTO;
import com.dakar.DakarApi.controller.dto.CreateUserDTO;
import com.dakar.DakarApi.controller.dto.UserDTO;
import com.dakar.DakarApi.entities.*;
import com.dakar.DakarApi.service.IRoleService;
import com.dakar.DakarApi.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleService roleService;

    @GetMapping("/findUserId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<UserEntity> optionalUser = userService.findById(id);

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();

            UserDTO userDTO = UserDTO.builder()

                    .id(user.getId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .username(user.getUsername())
                    .lastName(user.getLastName())
                    .numbrePhone(user.getNumbrePhone())
                    .roles(user.getRoles())
                    .bikeEntityList(user.getBikeEntityList())
                    .build();

            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario encontrado",  userDTO));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/save")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {

        Set<RoleEntity> roles = new HashSet<>();

        for (String roleName : createUserDTO.getRoles()) {
            ERole role = ERole.valueOf(roleName);
            Optional<RoleEntity> optionalRole = roleService.findByName(role);

            if (optionalRole.isPresent()) {
                roles.add(optionalRole.get());
            } else {
                RoleEntity newRole = RoleEntity.builder()
                        .name(role)
                        .build();
                roleService.save(newRole);
                roles.add(newRole);
            }
            }
        UserEntity userEntity = UserEntity.builder()
                .name(createUserDTO.getName())
                .username(createUserDTO.getEmail())
                .lastName(createUserDTO.getLastName())
                .email(createUserDTO.getEmail())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .numbrePhone(createUserDTO.getNumbrePhone())
                .dataCreate(LocalDate.now())
                .roles(roles)
                .build();

        userService.save(userEntity);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario guardado", createUserDTO ));
    }


    @GetMapping("/listAllUsers")
    public ResponseEntity<?> findAll(){
        List<UserDTO> userDTOList = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .name(user.getName())
                        .username(user.getUsername())
                        .lastName(user.getLastName())
                        .numbrePhone(user.getNumbrePhone())
                        .roles(user.getRoles())
                        .bikeEntityList(user.getBikeEntityList())
                        .build())
                .toList();

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "", userDTOList ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<UserEntity> optionalUser = userService.findById(id);

        if (optionalUser.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario eliminado con éxito", null ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "Usuario no encontrado", null));
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        Optional<UserEntity> userEntityOptional = userService.getName(name);

        if (userEntityOptional.isPresent()){
            UserEntity user = userEntityOptional.get();
            UserDTO userDTO = UserDTO.builder()
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .id(user.getId())
                    .email(user.getEmail())
                    .numbrePhone(user.getNumbrePhone())
                    .roles(user.getRoles())
                    .bikeEntityList(user.getBikeEntityList())
                    .build();
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario encontrado", userDTO ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "Usuario no encontrado", null));
    }

    @GetMapping("/listUserByRole/{role}")
    public ResponseEntity<?> listUserByRole(@PathVariable ERole role){
        List<UserDTO> userDTOList = userService.getUsersByRole(role)
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .name(user.getName())
                        .username(user.getUsername())
                        .lastName(user.getLastName())
                        .numbrePhone(user.getNumbrePhone())
                        .roles(user.getRoles())
                        .bikeEntityList(user.getBikeEntityList())
                        .build())
                .toList();

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario encontrado", userDTOList ));
    }

    @PutMapping("/udpate/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid CreateUserDTO userDTO, @PathVariable Long id){
        Optional<UserEntity> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()){
            UserEntity user = optionalUser.get();
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setUsername(userDTO.getEmail());
            user.setNumbrePhone(userDTO.getNumbrePhone());
            user.setEmail(userDTO.getEmail());
            System.out.println("esta dentro del if");
            userService.save(user);
            return ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario actualizadp", null ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "Usuario no encontrado", null));
    }

}
