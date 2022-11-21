package com.holeiko.database.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "motors_work", schema = "holeiko_db", catalog = "")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotorsWork {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "motor_id")
    private int motorId;
    @Basic
    @Column(name = "turn_on_time")
    private Timestamp turnOnTime;
    @Basic
    @Column(name = "turn_of_time")
    private Timestamp turnOfTime;
    @Basic
    @Column(name = "water_consume")
    private int waterConsume;
}
