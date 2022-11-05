package com.holeiko.lab5.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Areas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "square")
    private Integer square;
    @Basic
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic
    @Column(name = "longitude")
    private BigDecimal longitude;

    @OneToMany (mappedBy = "lightSensorInfoById")
    private Collection<LightSensorInfo> lightSensorInfos;

    @OneToMany (mappedBy = "area")
    private Collection<PumpsInfo> pumpsInfos;



    public Collection<LightSensorInfo> getLightSensorInfos() {
        return lightSensorInfos;
    }

    public void setLightSensorInfos(Collection<LightSensorInfo> lightSensorInfos) {
        this.lightSensorInfos = lightSensorInfos;
    }

    public Collection<PumpsInfo> getPumpsInfos() {
        return pumpsInfos;
    }

    public void setPumpsInfos(Collection<PumpsInfo> pumpsInfos) {
        this.pumpsInfos = pumpsInfos;
    }


    @ManyToOne
    @JoinColumn(name = "owner_client", referencedColumnName = "client_id", nullable = false)
    private Clients clientsByOwnerClient;

    public Areas() {}

    public Areas(Integer id, Integer square, BigDecimal latitude, BigDecimal longitude, Clients clientsByOwnerClient) {
        this.id = id;
        this.square = square;
        this.latitude = latitude;
        this.longitude = longitude;
        this.clientsByOwnerClient = clientsByOwnerClient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
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
        Areas areas = (Areas) o;
        return Objects.equals(id, areas.id) && Objects.equals(square, areas.square) && Objects.equals(latitude, areas.latitude) && Objects.equals(longitude, areas.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, square, latitude, longitude);
    }

    public Clients getClientsByOwnerClient() {
        return clientsByOwnerClient;
    }

    public void setClientsByOwnerClient(Clients clientsByOwnerClient) {
        this.clientsByOwnerClient = clientsByOwnerClient;
    }


}
