package org.zdanek.corporis.weight;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Long> {
	List<Weight> findByUserId(Long userId);
	//List<Weight> findByUserId(Long userId, Pageable pageable);
	Page<Weight> findByUserId(Long userId, Pageable pageable);
}
