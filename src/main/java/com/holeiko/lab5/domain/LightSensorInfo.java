package com.holeiko.lab5.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "light_sensor_info", schema = "holeiko_db", catalog = "")
public class LightSensorInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sensor_id")
    private Integer sensorId;
    @Basic
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic
    @Column(name = "longitude")
    private BigDecimal longitude;

    public Areas getLightSensorInfoById() {
        return lightSensorInfoById;
    }

    public void setLightSensorInfoById(Areas lightSensorInfoById) {
        this.lightSensorInfoById = lightSensorInfoById;
    }

    @ManyToOne
    @JoinColumn(name = "areas_id", nullable = false)
    private Areas lightSensorInfoById;


    @OneToMany(mappedBy = "lightSensorInfoBySensorId")
    private Collection<LightSensorWork> lightSensorWorksBySensorId;

    public LightSensorInfo(){

    }
    public LightSensorInfo(Integer sensorId, BigDecimal latitude, BigDecimal longitude, Areas lightSensorInfoById) {
        this.sensorId = sensorId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lightSensorInfoById = lightSensorInfoById;

    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightSensorInfo that = (LightSensorInfo) o;
        return Objects.equals(sensorId, that.sensorId) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, latitude, longitude);
    }

//    public Collection<Areas> getAreaLight() {
//        return areaLight;
//    }
//
//    public void setAreaLight(Collection<Areas> areaLight) {
//        this.areaLight = areaLight;
//    }

    public Collection<LightSensorWork> getLightSensorWorksBySensorId() {
        return lightSensorWorksBySensorId;
    }

    public void setLightSensorWorksBySensorId(Collection<LightSensorWork> lightSensorWorksBySensorId) {
        this.lightSensorWorksBySensorId = lightSensorWorksBySensorId;
    }
}
