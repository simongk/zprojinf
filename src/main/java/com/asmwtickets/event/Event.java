package com.asmwtickets.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Szymon Gasienica-Kotelnicki
 * 2017-04-01
 */

@Entity
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    public Event(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    private String name;
    private String location;
    private String date;

}
