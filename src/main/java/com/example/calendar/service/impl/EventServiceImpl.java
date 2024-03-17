package com.example.calendar.service.impl;

import com.example.calendar.entity.Event;
import com.example.calendar.exception.ResourceAlreadyExist;
import com.example.calendar.exception.ResourceNotFoundException;
import com.example.calendar.mapper.EventMapper;
import com.example.calendar.model.request.EventRequest;
import com.example.calendar.repository.EventRepository;
import com.example.calendar.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

	private EventRepository eventRepository;

	@CacheEvict(value = "allEvents", allEntries = true)
	public Event createEvent(EventRequest eventRequest) {
		Event event = EventMapper.INSTANCE.fromEventRequest(eventRequest);
		try {
			event = eventRepository.save(event);
			return event;
		} catch (NonTransientDataAccessException e) {
			throw new ResourceAlreadyExist("Event", "title", event.getTitle());
		}
	}

	@Cacheable(value = "allEvents")
	public List<Event> getAllEvents() {
		System.out.println("BUBUBUBU BUBUBUBU");
		return eventRepository.findAll();
	}

	@Cacheable(value = "events", key = "#id")
	public Event getEventById(Long id) {
		return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event", id.toString()));
	}

	@CacheEvict(value = "allEvents", allEntries = true)
	public Event updateEventById(Long id, EventRequest newEventRequest) {
		Event event = eventRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
		EventMapper.INSTANCE.updateEvent(newEventRequest, event);
		return eventRepository.save(event);
	}

	@CacheEvict(value = "allEvents", allEntries = true)
	public void deleteEventById(Long id) {
		eventRepository.deleteById(id);
	}

}
