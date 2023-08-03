package com.elevator.service;

import java.util.List;

import com.elevator.model.Elevator;


public interface ElevatorService {

	List<Elevator> getAllElevators();
    Elevator getElevatorById(int id);
    Elevator sendElevatorRequest(int floor);
    Elevator setElevatorDestination(int id, int floor);
    List<Integer> getElevatorQueue(int id);
    Elevator resetElevator(int id);

}
