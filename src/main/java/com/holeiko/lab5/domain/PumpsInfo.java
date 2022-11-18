package com.holeiko.lab5.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pumps_info", schema = "holeiko_db", catalog = "")
public class PumpsInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "count_of_motors")
    private Integer countOfMotors;
    @Basic
    @Column(name = "water_consume")
    private Integer waterConsume;

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    @ManyToOne
    @JoinColumn(name = "areas_id", referencedColumnName = "id", nullable = false)
    private Areas area;

    @OneToMany(mappedBy = "pumpsInfoByPump")
    private Collection<WaterSystem> waterSystemsById;

    public PumpsInfo(Integer id, Integer countOfMotors, Integer waterConsume, Areas area) {
        this.id = id;
        this.countOfMotors = countOfMotors;
        this.waterConsume = waterConsume;
        this.area = area;

    }
    public PumpsInfo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountOfMotors() {
        return countOfMotors;
    }

    public void setCountOfMotors(Integer countOfMotors) {
        this.countOfMotors = countOfMotors;
    }

    public Integer getWaterConsume() {
        return waterConsume;
    }

    public void setWaterConsume(Integer waterConsume) {
        this.waterConsume = waterConsume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PumpsInfo pumpsInfo = (PumpsInfo) o;
        return Objects.equals(id, pumpsInfo.id) && Objects.equals(countOfMotors, pumpsInfo.countOfMotors) && Objects.equals(waterConsume, pumpsInfo.waterConsume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countOfMotors, waterConsume);
    }




    public Collection<WaterSystem> getWaterSystemsById() {
        return waterSystemsById;
    }

    public void setWaterSystemsById(Collection<WaterSystem> waterSystemsById) {
        this.waterSystemsById = waterSystemsById;
    }
}
