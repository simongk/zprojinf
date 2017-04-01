package com.asmwtickets.event;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Szymon Gasienica-Kotelnicki
 * 2017-04-01
 */

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private String date;

}
