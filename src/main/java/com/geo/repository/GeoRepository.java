package com.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.entity.GeoEntity;

public interface GeoRepository extends JpaRepository<GeoEntity, Long> {

}
