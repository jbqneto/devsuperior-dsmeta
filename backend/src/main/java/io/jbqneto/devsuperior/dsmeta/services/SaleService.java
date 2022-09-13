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
        var dateMin = "".equals(minDate)
                ? LocalDate.now().minusYears(1)
                : LocalDate.parse(minDate);

        var dateMax = "".equals(maxDate) ? LocalDate.now() : LocalDate.parse(maxDate);

        return this.repository.findByPeriod(pageable, dateMin, dateMax);
    }

    public Optional<Sale> findById(Long id) {
        return this.repository.findById(id);
    }
}
