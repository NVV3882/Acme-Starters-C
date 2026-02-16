package acme.entities.audit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuditReportRepository extends CrudRepository<AuditReport, Integer> {

	@Query("SELECT SUM(s.hours) FROM AuditSection s WHERE s.report.id = ?1")
	Integer computeHours(Integer reportId);

	// Compute months as decimal using MariaDB/ MySQL functions: difference in seconds divided by average seconds per month (~30.44 days)
	@Query(value = "SELECT (UNIX_TIMESTAMP(end_moment) - UNIX_TIMESTAMP(start_moment)) / 2629746.0 FROM audit_report WHERE id = ?1", nativeQuery = true)
	Double computeMonthsActive(Integer reportId);

}