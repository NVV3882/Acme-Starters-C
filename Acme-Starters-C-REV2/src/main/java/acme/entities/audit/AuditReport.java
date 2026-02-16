package acme.entities.audit;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidUrl;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = { @Index(columnList = "draftMode, startMoment"), @Index(columnList = "auditor_id, id") })
public class AuditReport extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString
	@Column(unique = true)
	private String ticker;

	@Mandatory
	@ValidString
	@Column
	private String name;

	@Mandatory
	@ValidString
	@Column
	private String description;

	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.TIMESTAMP)
	private Date startMoment;

	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.TIMESTAMP)
	private Date endMoment;

	@Optional
	@ValidUrl
	@Column
	private String moreInfo;

	@Mandatory
	@Column
	private boolean draftMode;

	// Derived attributes -----------------------------------------------------

	@Transient
	@Autowired
	private AuditReportRepository repository;

	@Transient
	public Double getMonthsActive() {
		Double result;

		result = this.repository.computeMonthsActive(this.getId());

		return result == null ? 0.0 : result;
	}

	@Transient
	public Integer getHours() {
		Integer result;

		result = this.repository.computeHours(this.getId());

		return result == null ? 0 : result;
	}

	// Relationships ----------------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne
	private acme.realms.Auditor	auditor;

	@Valid
	@OneToMany(mappedBy = "report", fetch = FetchType.LAZY)
	private List<AuditSection> sections;

}