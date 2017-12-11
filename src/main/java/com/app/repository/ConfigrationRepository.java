package com.app.repository;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.Configration;
@Cacheable
public interface ConfigrationRepository extends JpaRepository<Configration , Long> {

}
