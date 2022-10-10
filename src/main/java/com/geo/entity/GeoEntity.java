package com.geo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="geo_master")
public class GeoEntity extends AuditEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long geoId;
    @NotNull
    @Digits(integer = 6, fraction = 7, message = "at max 7 precision allowed")
    private Double latitude;
    @NotNull
    @Digits(integer = 6, fraction = 7, message = "at max 7 precision allowed")
    private Double longitude;
    @NotNull
    @Digits(integer = 6, fraction = 7, message = "at max 7 precision allowed")
    private Double radius;

    public Long getGeoId() {
        return geoId;
    }

    public void setGeoId(Long geoId) {
        this.geoId = geoId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

}
