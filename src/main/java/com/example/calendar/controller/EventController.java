package com.example.calendar.controller;

import com.example.calendar.entity.Event;
import com.example.calendar.model.request.EventRequest;
import com.example.calendar.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

	private final EventService eventService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Event createEvent(@Valid @RequestBody EventRequest eventRequest) {
		return eventService.createEvent(eventRequest);
	}

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Event> getAllEvents() {
		System.out.println(eventService.getAllEvents());
		return eventService.getAllEvents();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Event getEvent(@PathVariable Long id) {
		return eventService.getEventById(id);
	}

	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Event updateEvent(@PathVariable Long id, @Valid @RequestBody EventRequest eventRequest) {
		return eventService.updateEventById(id, eventRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeEvent(@PathVariable Long id) {
		eventService.deleteEventById(id);
	}
}
