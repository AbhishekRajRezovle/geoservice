package com.geo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.constant.ApplicationConstants;
import com.geo.dto.ErrorResponseDto;
import com.geo.dto.ResponseDto;
import com.geo.dto.SuccessResponseDto;
import com.geo.entity.GeoEntity;
import com.geo.repository.GeoRepository;

@Service
public class GeoService {
	
	@Autowired
    private GeoRepository geoRepository;

    /*
    This methods creates new geo and returns unique id in the response
     */
    public ResponseDto createGeofence(GeoEntity geoModel) {
        return new SuccessResponseDto(geoRepository.save(geoModel));
    }

    /*
    This method returns all available geofence in the system.
     */
    public ResponseDto getGeoFences() {
        List<GeoEntity> geoFences = geoRepository.findAll();
        return new SuccessResponseDto(geoFences);
    }

    /*
       This method delete geo in the system bases on unique geoId.
        */
    public ResponseDto deleteGeoFence(Long geoId) {
        if (geoRepository.findById(geoId).isPresent()) {
        	geoRepository.deleteById(geoId);
            return new SuccessResponseDto(ApplicationConstants.HTTP_RESPONSE_SUCCESS_CODE);
        }
        return new ErrorResponseDto(ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND, ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND_MSG);
    }

    /*
     This method updates geo data in the system bases on unique geoId.
      */
    public ResponseDto updateGeoFence(GeoEntity geoModel) {
        return geoRepository.findById(geoModel.getGeoId()).isPresent() ? new SuccessResponseDto(geoRepository.save(geoModel)) : new ErrorResponseDto(ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND, ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND_MSG);
    }


}
