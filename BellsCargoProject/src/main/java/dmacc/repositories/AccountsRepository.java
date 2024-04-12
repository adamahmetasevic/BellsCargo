package dmacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Account;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer> {
	
}
