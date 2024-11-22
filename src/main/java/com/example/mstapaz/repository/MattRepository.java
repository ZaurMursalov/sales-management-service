package com.example.mstapaz.repository;

import com.example.mstapaz.entity.MattEntity;
import com.example.mstapaz.model.dto.MattDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MattRepository extends JpaRepository<MattEntity,Long>,
        JpaSpecificationExecutor<MattEntity> {

Optional<MattEntity>findByName(String name);
}
