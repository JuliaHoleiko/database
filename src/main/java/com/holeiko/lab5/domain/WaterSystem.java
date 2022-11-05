package com.holeiko.lab5.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "water_system", schema = "holeiko_db", catalog = "")
public class WaterSystem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "count_of_nozzles")
    private Integer countOfNozzles;
    @OneToMany(mappedBy = "waterSystemBySystemId")
    private Collection<Nozzle> nozzlesById;



    @ManyToOne
    @JoinColumn(name = "pump", referencedColumnName = "id", nullable = false)
    private PumpsInfo pumpsInfoByPump;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountOfNozzles() {
        return countOfNozzles;
    }

    public void setCountOfNozzles(Integer countOfNozzles) {
        this.countOfNozzles = countOfNozzles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterSystem that = (WaterSystem) o;
        return Objects.equals(id, that.id) && Objects.equals(countOfNozzles, that.countOfNozzles);
    }
    public WaterSystem(){}
    public WaterSystem(Integer id, Integer countOfNozzles,  PumpsInfo pumpsInfoByPump) {
        this.id = id;
        this.countOfNozzles = countOfNozzles;
        this.pumpsInfoByPump = pumpsInfoByPump;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countOfNozzles);
    }

    public Collection<Nozzle> getNozzlesById() {
        return nozzlesById;
    }

    public void setNozzlesById(Collection<Nozzle> nozzlesById) {
        this.nozzlesById = nozzlesById;
    }


    public PumpsInfo getPumpsInfoByPump() {
        return pumpsInfoByPump;
    }

    public void setPumpsInfoByPump(PumpsInfo pumpsInfoByPump) {
        this.pumpsInfoByPump = pumpsInfoByPump;
    }
}
