package com.elevator.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.elevator.model.Elevator;
import com.elevator.repository.ElevatorRepository;

@Repository
public class ElevatorRepositoryImpl implements ElevatorRepository{
	
	 private final List<Elevator> elevators = new ArrayList<>();

	    @Override
	    public List<Elevator> getAllElevators() {
	        return elevators;
	    }

	    @Override
	    public Elevator getElevatorById(int id) {
	        for (Elevator elevator : elevators) {
	            if (elevator.getId() == id) {
	                return elevator;
	            }
	        }
	        return null; // we can also throw an exception for elevator not found
	    }

	    @Override
	    public Elevator saveElevator(Elevator elevator) {
	        if (elevator.getId() == 0) {
	            // New elevator, generate ID
	            elevator.setId(elevators.size() + 1);
	            elevators.add(elevator);
	        } else {
	            // Existing elevator, update it in the list
	            for (int i = 0; i < elevators.size(); i++) {
	                if (elevators.get(i).getId() == elevator.getId()) {
	                    elevators.set(i, elevator);
	                    break;
	                }
	            }
	        }
	        return elevator;
	    }

}
