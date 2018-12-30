package com.deepak.multiple.repository.sql;

import com.deepak.multiple.entity.sql.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyEntityRepository extends JpaRepository<DummyEntity, Long> {
}
