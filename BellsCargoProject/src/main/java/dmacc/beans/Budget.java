package dmacc.beans;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Budget {
	@Id
	@GeneratedValue
	private int id;
	private String budgetName;
	private double budgetTotal;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "budget")
	private List<BudgetItem> budgetItems;
    
    public void setBudgetTotal() {
    	if (budgetItems != null) {
    		for(var item : budgetItems) {
        		this.budgetTotal += item.getBudgetAmount();
        	}
    	}
    }
    
    public void setBudgetItems(BudgetItem bi) {
    	if(budgetItems == null) {
    		budgetItems = new ArrayList<>();
    	}
    	
    	this.budgetItems.add(bi);
    	setBudgetTotal();
    }
}
