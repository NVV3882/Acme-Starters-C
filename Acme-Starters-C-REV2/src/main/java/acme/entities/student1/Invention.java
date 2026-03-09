
package acme.entities.student1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.realms.Inventor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invention extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Column(unique = true)
	private String				ticker;

	@Mandatory
	@Column
	private String				name;

	@Mandatory
	@Column
	private String				description;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	private Date				startMoment;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	private Date				endMoment;

	@Optional
	@Column
	private String				moreInfo;

	@Mandatory
	@Column
	private Boolean				draftMode;

<<<<<<< Updated upstream:Acme-Starters-C-REV2/src/main/java/acme/entities/student1/Invention.java
=======
	/*
	 * @Mandatory
	 * 
	 * @Valid
	 * 
	 * @Transient
	 * public Double monthsActive() {
	 * 
	 * }
	 */

	/*
	 * @Mandatory
	 * 
	 * @ValidMoney(min = 0.1)
	 * 
	 * @Transient
	 * public Money cost() {
	 * 
	 * CampaignRepository inventionRepo;
	 * Money dinero;
	 * dinero.setAmount(inventionRepo.sumCostOfThePartsOfAInvention(this.getId());
	 * dinero.setCurrency(this.description);
	 * 
	 * 
	 * }
	 * 
	 */

>>>>>>> Stashed changes:Acme-Starters-C-REV2/src/main/java/acme/entities/invention/Invention.java
	@Mandatory
	@ManyToOne
	private Inventor			inventor;

}
