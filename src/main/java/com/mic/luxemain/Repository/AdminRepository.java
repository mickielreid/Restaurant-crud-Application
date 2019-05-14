package com.mic.luxemain.Repository;

import com.mic.luxemain.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findByUsername(String userName);
}
