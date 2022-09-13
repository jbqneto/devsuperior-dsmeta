package io.jbqneto.devsuperior.dsmeta.controller;

import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;
import io.jbqneto.devsuperior.dsmeta.entities.Sale;
import io.jbqneto.devsuperior.dsmeta.services.NotificationService;
import io.jbqneto.devsuperior.dsmeta.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    private final SaleService service;
    private final NotificationService notificationService;



    public SaleController(SaleService service, NotificationService notificationService) {
        this.service = service;
        this.notificationService = notificationService;
    }

    @GetMapping(value = "", produces = "application/json")
    public Page<Sale> listSales(
            Pageable pageable,
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate) {

        return this.service.find(pageable, minDate, maxDate);
    }

    @GetMapping(value = "/{saleId}/notification", produces = "application/json")
    public ClientMessageResponse sendSMS(@PathVariable Long saleId) {
        var sale = this.service.findById(saleId)
                .orElseThrow(() -> new NoSuchElementException("Sale not found"));

        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();

        StringBuilder message = new StringBuilder();
        message
                .append("O vendedor ")
                .append(sale.getSellerName())
                .append(" foi destaque em ")
                .append(date)
                .append(" com um total de R$ ")
                .append(sale.getAmount());

        return this.notificationService.sendMessage(message.toString());
    }
}
