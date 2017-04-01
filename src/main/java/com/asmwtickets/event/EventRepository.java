package com.asmwtickets.event;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Szymon Gasienica-Kotelnicki
 * 2017-04-01
 */
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findByName(String name);
}
