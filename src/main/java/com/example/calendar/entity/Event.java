package com.example.calendar.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "events")
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Column(nullable = false)
	@Getter
	@Setter
	private String title;

	@Column(nullable = false)
	@Getter
	@Setter
	private LocalDateTime startTime;

	@Column
	@Getter
	@Setter
	private LocalDateTime endTime;

	@Column
	@Getter
	@Setter
	private String location;

	@Column
	@Getter
	@Setter
	private String description;

	@Enumerated(EnumType.STRING)
	@Column
	@Getter
	@Setter
	private RecurrenceType recurrence = RecurrenceType.NONE;

	@Column
	@Getter
	@Setter
	private Integer reminderMinutesBefore;
}