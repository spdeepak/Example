package com.github.spdeepak.multipledb.repository.sql;

import com.github.spdeepak.multipledb.entity.sql.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyEntityRepository extends JpaRepository<DummyEntity, Long> {
}
