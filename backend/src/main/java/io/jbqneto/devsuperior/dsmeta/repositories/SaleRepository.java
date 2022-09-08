package io.jbqneto.devsuperior.dsmeta.repositories;

import io.jbqneto.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT S FROM Sale S WHERE S.date BETWEEN :min AND :max ORDER BY S.amount DESC")
    Page<Sale> findByPeriod(Pageable pageable, LocalDate min, LocalDate max);
}
