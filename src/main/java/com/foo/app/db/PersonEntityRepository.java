package com.foo.app.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE persons", nativeQuery = true)
    void truncateTable();
}