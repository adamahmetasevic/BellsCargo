package dmacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
}
