package com.geo.service;

import com.geo.dto.ResponseDto;
import com.geo.entity.GeoEntity;

public interface GeoService {
	
public ResponseDto createGeofence(GeoEntity geoEntity);
    
    public ResponseDto getGeoFences();
    
    public ResponseDto deleteGeoFence(Long geoId);
    
    public ResponseDto updateGeoFence(GeoEntity geoEntity);

}
