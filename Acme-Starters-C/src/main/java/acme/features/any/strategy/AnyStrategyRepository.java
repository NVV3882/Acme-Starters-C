
package acme.features.any.strategy;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.strategy.Strategy;

@Repository
public interface AnyStrategyRepository extends AbstractRepository {

	@Query("SELECT s FROM Strategy s WHERE s.id = :id")
	Strategy findStrategyById(int id);

	@Query("SELECT s FROM Strategy s")
	Collection<Strategy> findAllStrategies();

}
