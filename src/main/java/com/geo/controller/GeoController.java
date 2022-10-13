package com.geo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geo.dto.ResponseDto;
import com.geo.entity.GeoEntity;
import com.geo.service.GeoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/geo/api")
public class GeoController {

	@Autowired
	private GeoService geoService;

	@PostMapping("/geofences")
	public ResponseDto addGeoFence(@Valid @RequestBody GeoEntity request) {
		log.info("creating geofence for request {}", request);
		return geoService.createGeofence(request);
	}

	@GetMapping("/geofences")
	public ResponseDto getGeoFences() {
		log.info("finding geofence list ");
		return geoService.getGeoFences();
	}

	@DeleteMapping("/geofences"+"/{geoId}")
	public ResponseDto deleteGeoFence(@PathVariable final Long geoId) {
		log.info("deleting geofence for {} ", geoId);
		return geoService.deleteGeoFence(geoId);
	}

	@PutMapping("/geofences")
	public ResponseDto updateGeoFence(@Valid @RequestBody GeoEntity request) {
		log.info("updating geofence for {}", request);
		return geoService.updateGeoFence(request);
	}

}
