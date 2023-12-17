package com.example.SpringBootHR.model;

import com.example.SpringBootHR.model.entity.Employee;
import com.example.SpringBootHR.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.position.id=:positionId")
    List<Employee> getEmployeesByPositionId(@Param("positionId") Long positionId);

    @Query("SELECT e FROM Employee e WHERE e.position.name=:positionName")
    List<Employee> getEmployeesByPositionName(@Param("positionName") String positionName);

    @Query("SELECT p FROM Position p")
    List<Position> getAllPosition();

}
