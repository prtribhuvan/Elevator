package com.elevator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elevator.model.Elevator;
import com.elevator.service.ElevatorService;

@RestController
public class ElevatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ElevatorController.class);

	private final ElevatorService elevatorService;

	@Autowired
	public ElevatorController(ElevatorService elevatorService) {
		this.elevatorService = elevatorService;
	}

	@PostMapping("/elevator/request")
	public Elevator sendElevatorRequest(@RequestBody int floor) {
		logger.info("In Rest Controller->saveElevator, Save Elevator data");

		return elevatorService.sendElevatorRequest(floor);
	}

	@GetMapping("/elevator/status")
	public List<Elevator> getElevatorStatus() {
		return elevatorService.getAllElevators();
	}

	@GetMapping("/elevator/{id}")
	public Elevator getElevatorDetails(@PathVariable int id) {
		return elevatorService.getElevatorById(id);
	}

	@PutMapping("/elevator/{id}/destination")
	public Elevator setElevatorDestination(@PathVariable int id, @RequestBody int floor) {
		return elevatorService.setElevatorDestination(id, floor);
	}

	@GetMapping("/elevator/{id}/queue")
	public List<Integer> getElevatorQueue(@PathVariable int id) {
		return elevatorService.getElevatorQueue(id);
	}

	@PutMapping("/elevator/{id}/reset")
	public Elevator resetElevator(@PathVariable int id) {
		return elevatorService.resetElevator(id);
	}


}
