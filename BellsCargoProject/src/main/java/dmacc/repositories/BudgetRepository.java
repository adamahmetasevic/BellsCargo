package dmacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
	
}
