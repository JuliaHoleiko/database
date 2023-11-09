package com.holeiko.lab5.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Nozzle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "max_water_consume")
    private Integer maxWaterConsume;
    @Basic
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Basic
    @Column(name = "latitude")
    private BigDecimal latitude;
    @ManyToOne
    @JoinColumn(name = "system_id", referencedColumnName = "id", nullable = false)
    private WaterSystem waterSystemBySystemId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxWaterConsume() {
        return maxWaterConsume;
    }

    public void setMaxWaterConsume(Integer maxWaterConsume) {
        this.maxWaterConsume = maxWaterConsume;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nozzle nozzle = (Nozzle) o;
        return Objects.equals(id, nozzle.id) && Objects.equals(maxWaterConsume, nozzle.maxWaterConsume) && Objects.equals(longitude, nozzle.longitude) && Objects.equals(latitude, nozzle.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxWaterConsume, longitude, latitude);
    }

    public WaterSystem getWaterSystemBySystemId() {
        return waterSystemBySystemId;
    }

    public void setWaterSystemBySystemId(WaterSystem waterSystemBySystemId) {
        this.waterSystemBySystemId = waterSystemBySystemId;
    }
}
