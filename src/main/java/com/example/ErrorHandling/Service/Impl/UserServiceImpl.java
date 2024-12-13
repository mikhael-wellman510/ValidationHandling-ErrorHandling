package com.example.ErrorHandling.Service.Impl;

import com.example.ErrorHandling.DTO.RoleRequest;
import com.example.ErrorHandling.DTO.RoleResponse;
import com.example.ErrorHandling.DTO.UserRequest;
import com.example.ErrorHandling.DTO.UserResponse;
import com.example.ErrorHandling.Entity.Role;
import com.example.ErrorHandling.Entity.User;
import com.example.ErrorHandling.Repositori.RoleRepository;
import com.example.ErrorHandling.Repositori.UserRepository;
import com.example.ErrorHandling.Service.RoleService;
import com.example.ErrorHandling.Service.UserService;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    public UserServiceImpl(UserRepository userRepository , RoleService roleService){
        this.userRepository =  userRepository;
        this.roleService = roleService;

    }

    @Override
    @Transactional
    public UserResponse addUser(UserRequest userRequest) {
        // Todo-> Find Id
        Role findRole = roleService.findRoleById(userRequest.getRoleId());
        User save = userRepository.save(User.builder()
                .name(userRequest.getName())
                .hobby(userRequest.getHobby())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .roleId(findRole)
                .build());
        return UserResponse.builder()
                .id(save.getId())
                .name(save.getName())
                .hobby(save.getHobby())
                .age(save.getAge())
                .address(save.getAddress())
                .email(save.getEmail())
                .phoneNumber(save.getPhoneNumber())
                .roleResponse(RoleResponse.builder()
                        .id(findRole.getId())
                        .roleName(findRole.getRoleName())
                        .description(findRole.getDescription())
                        .build())
                .build();
    }

    @Override
    public Page<UserResponse> findUserAndRole(String user, String role, Integer page , Integer size) {
        int pages = page - 1;
        Pageable pageable = PageRequest.of(pages, size);

        Specification<User> specification = ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<User , Role> roles = root.join("roleId");
            System.out.println("hasil roles " + roles);
            if (user != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + user.toLowerCase() + "%"));
            }

            if (role != null){
                predicates.add(criteriaBuilder.equal(roles.get("roleName") , role));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

        Page<User> findDataResult = userRepository.findAll(specification , pageable);
        List<UserResponse> data = new ArrayList<>();
        for (User a : findDataResult.getContent()){
            UserResponse u = UserResponse.builder()
                    .id(a.getId())
                    .name(a.getName())
                    .hobby(a.getHobby())
                    .age(a.getAge())
                    .address(a.getAddress())
                    .email(a.getEmail())
                    .phoneNumber(a.getPhoneNumber())
                    .roleResponse(RoleResponse.builder()
                            .id(a.getRoleId().getId())
                            .roleName(a.getRoleId().getRoleName())
                            .description(a.getRoleId().getDescription())
                            .build())
                    .build();
            data.add(u);
        }

        return new PageImpl<>(data,pageable,findDataResult.getTotalElements());
    }
}
