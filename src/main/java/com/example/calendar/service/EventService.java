package com.example.calendar.service;

import com.example.calendar.entity.Event;
import com.example.calendar.model.request.EventRequest;

import java.util.List;

public interface EventService {

	Event createEvent(EventRequest projectRequest);

	List<Event> getAllEvents();

	Event getEventById(Long id);

	Event updateEventById(Long id, EventRequest newEventRequest);

	void deleteEventById(Long id);
}
