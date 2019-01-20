package org.zdanek.corporis.weight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Long> {
	List<Weight> findByUserId(Long userId);
}
