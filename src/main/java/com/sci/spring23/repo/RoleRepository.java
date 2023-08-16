package com.sci.spring23.repo;

import com.sci.spring23.dto.ERole;
import com.sci.spring23.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(ERole name);
}
