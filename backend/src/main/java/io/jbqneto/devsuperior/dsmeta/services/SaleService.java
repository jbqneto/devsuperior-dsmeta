package io.jbqneto.devsuperior.dsmeta.services;

import io.jbqneto.devsuperior.dsmeta.entities.Sale;
import io.jbqneto.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository repository;

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public Page<Sale> find(
            Pageable pageable,
            String minDate,
            String maxDate
    ) {

        return this.repository.findByPeriod(pageable, LocalDate.parse(minDate), LocalDate.parse(maxDate));
    }

    public Optional<Sale> findById(Long id) {
        return this.repository.findById(id);
    }
}
