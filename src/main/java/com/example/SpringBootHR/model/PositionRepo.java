package com.example.SpringBootHR.model;

import com.example.SpringBootHR.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepo extends JpaRepository<Position, Long> {
}
