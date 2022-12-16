package org.horizonefele.dao;

import java.util.List;

import org.horizonefele.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {
	@Query("select t from Team t where t.name like	:x")
	public List<Team> findByName(@Param("x")String mc);
}

