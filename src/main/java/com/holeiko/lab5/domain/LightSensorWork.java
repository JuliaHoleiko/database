package com.holeiko.lab5.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;



@Entity
@Table(name = "light_sensor_work", schema = "holeiko_db", catalog = "")
public class LightSensorWork {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "light")
    private Integer light;
    @Basic
    @Column(name = "time")
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id", nullable = false)
    private LightSensorInfo lightSensorInfoBySensorId;

    public LightSensorWork(){}

    public LightSensorWork(Integer id, Integer light, Timestamp time, LightSensorInfo lightSensorInfoBySensorId) {
        this.id = id;
        this.light = light;
        this.time = time;
        this.lightSensorInfoBySensorId = lightSensorInfoBySensorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightSensorWork that = (LightSensorWork) o;
        return Objects.equals(id, that.id) && Objects.equals(light, that.light) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, light, time);
    }

    public LightSensorInfo getLightSensorInfoBySensorId() {
        return lightSensorInfoBySensorId;
    }

    public void setLightSensorInfoBySensorId(LightSensorInfo lightSensorInfoBySensorId) {
        this.lightSensorInfoBySensorId = lightSensorInfoBySensorId;
    }
}
