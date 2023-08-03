package com.elevator.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elevator.model.Elevator;
import com.elevator.repository.ElevatorRepository;
import com.elevator.service.ElevatorService;

@Service
public class ElevatorServiceImpl implements ElevatorService{
	
	
	private static final Logger logger = LoggerFactory.getLogger(ElevatorServiceImpl.class);

	private final ElevatorRepository elevatorRepository;

	@Autowired
	public ElevatorServiceImpl(ElevatorRepository elevatorRepository) {
		this.elevatorRepository = elevatorRepository;
	}

	@Override
	public List<Elevator> getAllElevators() {
		return elevatorRepository.getAllElevators();
	}

	@Override
	public Elevator getElevatorById(int id) {
		return elevatorRepository.getElevatorById(id);
	}

	@Override
	public Elevator sendElevatorRequest(int floor) {
		// logic to select the elevator and set its target floor
		// we'll select the first available elevator
		List<Elevator> elevators = elevatorRepository.getAllElevators();
		Elevator elevator = new Elevator();
		elevator.setId(elevators.size() + 1);
		elevator.setStatus("moving");
		elevator.setTargetFloor(floor);
		logger.info("In Employee Service Impl>> sendElevator()");
		return elevatorRepository.saveElevator(elevator);
	}

	@Override
	public Elevator setElevatorDestination(int id, int floor) {
		Elevator elevator = elevatorRepository.getElevatorById(id);
		if (elevator != null) {
			elevator.setTargetFloor(floor);
			return elevatorRepository.saveElevator(elevator);
		}
		return null; // we can also throw an exception for elevator not found
	}

	@Override
	public List<Integer> getElevatorQueue(int id) {
		Elevator elevator = elevatorRepository.getElevatorById(id);
		if (elevator != null) {
			// Logic to generate the queued floors based on elevator status
			List<Integer> queue = List.of(elevator.getCurrentFloor(), elevator.getTargetFloor());
			return queue;
		}
		return null; // can also throw an exception for elevator not found
	}

	@Override
	public Elevator resetElevator(int id) {
		Elevator elevator = elevatorRepository.getElevatorById(id);
		if (elevator != null) {
			// logic to reset the elevator to its initial state
			// we'll reset its target floor to 0 and set status to idle
			elevator.setTargetFloor(0);
			elevator.setStatus("idle");
			return elevatorRepository.saveElevator(elevator);
		}
		return null; // can also throw an exception for elevator not found
	}


}
