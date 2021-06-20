package com.homework.leasing.repository;

import com.homework.leasing.repository.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeasingRepository extends JpaRepository<Lease, UUID> {
}
