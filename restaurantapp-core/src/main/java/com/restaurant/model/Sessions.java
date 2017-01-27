package com.restaurant.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Sessions {

	private int sessionId;
	private String sessionName;
	private LocalTime fromTime;
	private LocalTime toTime;
	private int quantity;

}
