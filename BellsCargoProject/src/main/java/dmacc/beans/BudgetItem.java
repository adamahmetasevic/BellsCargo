package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetItem {
	@Id
	@GeneratedValue
	private int Id;
	private String item;
	private String category;
	private double budgetAmount;
	
    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;
}
