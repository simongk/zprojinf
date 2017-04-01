package com.asmwtickets;

import com.asmwtickets.event.Event;
import com.asmwtickets.event.EventController;
import com.asmwtickets.event.EventRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketsApplicationTests {

	@Autowired
	private EventRepository repository;
    @Autowired
    private EventController controller;

	@Test
	public void contextLoads() {
	}

	@Test
    public void eventShouldBeAdded(){
	    //given
	    Event event = new Event();
	    event.setName("asd");

	    //when
	    controller.addEvent(event);

	    //then
        Assert.assertEquals(event,repository.findByName("asd"));
    }

    @Test
    public void eventShouldBeUpdated(){
        //given
        controller.addToDatabase();
        Event newEvent = new Event();
        newEvent.setName("Im Updated");

        //when
        controller.updateEvent(1L,newEvent);

        //then
        Assert.assertNotEquals(repository.findOne(1L).getName(), "Spring Boot Workshop");
    }

    @Test
    public void eventShouldBeReturnedByItsName(){
        //given
        controller.addToDatabase();

        //when
        Event event = controller.getEventByName("Gowno");


        //then
        Assert.assertEquals(repository.findByName("Gowno"),event);

    }


}
