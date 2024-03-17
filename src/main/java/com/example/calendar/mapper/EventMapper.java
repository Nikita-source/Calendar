package com.example.calendar.mapper;

import com.example.calendar.entity.Event;
import com.example.calendar.model.request.EventRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {

	EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

	Event fromEventRequest(EventRequest eventRequest);

	void updateEvent(EventRequest eventRequest, @MappingTarget Event event);
}
