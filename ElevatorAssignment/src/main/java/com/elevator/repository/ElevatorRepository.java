package com.elevator.repository;

import java.util.List;

import com.elevator.model.Elevator;

public interface ElevatorRepository {


    Elevator saveElevator(Elevator elevator);
	List<Elevator> getAllElevators();
    Elevator getElevatorById(int id);
	
	
}
