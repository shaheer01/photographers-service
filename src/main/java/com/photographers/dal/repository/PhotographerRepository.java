package com.photographers.dal.repository;

import com.photographers.dal.entity.EventType;
import com.photographers.dal.entity.Photographers;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Cacheable(cacheNames = "photographers")
@Repository
public interface PhotographerRepository extends JpaRepository<Photographers, Long> {

    @CacheEvict(key = "#id")
    List<Photographers> findByEventType(EventType eventType);
}
