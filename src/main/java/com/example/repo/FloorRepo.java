package com.example.repo;

import com.example.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepo extends JpaRepository<Floor, Integer> {
}
