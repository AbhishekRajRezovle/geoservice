package com.geo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geo.dto.ResponseDto;
import com.geo.entity.GeoEntity;
import com.geo.repository.GeoRepository;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	
	@Mock
	GeoRepository geoRepository;
	@InjectMocks
	GeoService geoService;
	
	GeoEntity geoEntity = new GeoEntity();
    List<GeoEntity> geoEntities = new ArrayList<>();
    
    @BeforeEach
    public void setup() {
    	geoEntity.setGeoId(123L);
    	geoEntity.setRadius(10000.0);
    	geoEntity.setLatitude(10.0);
    	geoEntity.setLongitude(11.0);
    	geoEntities.add(geoEntity);
    }
    
    @Test
    void createGeo() {
        given(geoRepository.save(Mockito.any())).willReturn(geoEntity);
        GeoEntity geoEntityResponse = (GeoEntity) geoService.createGeofence(geoEntity).getData();
        Assertions.assertEquals(geoEntity.getGeoId(),geoEntityResponse.getGeoId());
    }

    @Test
    void getGeo() {
        given(geoRepository.findAll()).willReturn(geoEntities);
        List<GeoEntity> geoModelResponse = (List<GeoEntity>) geoService.getGeoFences().getData();
        Assertions.assertEquals(geoEntities.size(),geoModelResponse.size());
    }

    @Test
    void updateGeo() {
    	geoEntity.setLongitude(11.23);
        given(geoRepository.findById(Mockito.any())).willReturn(Optional.of(geoEntity));
        given(geoRepository.save(geoEntity)).willReturn(geoEntity);
        ResponseDto geoModelResponse = geoService.updateGeoFence(geoEntity);
        Assertions.assertEquals(200,geoModelResponse.getCode());
    }

    @Test
    void updateGeo_failed() {
    	geoEntity.setGeoId(9L);
    	geoEntity.setLongitude(11.23);
        given(geoRepository.findById(Mockito.any())).willReturn(Optional.empty());
        ResponseDto geoModelResponse = geoService.updateGeoFence(geoEntity);
        Assertions.assertEquals(404,geoModelResponse.getCode());
    }

    @Test
    void deleteGeo() {
        given(geoRepository.findById(Mockito.any())).willReturn(Optional.of(geoEntity));
        ResponseDto geoModelResponse =  geoService.deleteGeoFence(geoEntity.getGeoId());
        Assertions.assertEquals(200,geoModelResponse.getCode());
    }

}
