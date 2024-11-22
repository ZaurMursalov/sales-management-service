package com.example.mstapaz.repository;

import com.example.mstapaz.entity.UserPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<UserPermissionEntity,Long> {

   Optional<UserPermissionEntity>findByUserIdAndPermissionNameAndProductName(String userId,String permissionName,String productName);
}
