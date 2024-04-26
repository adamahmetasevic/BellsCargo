package dmacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.BudgetItem;

public interface BudgetItemRepository extends JpaRepository<BudgetItem, Integer> {

}
