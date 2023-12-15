package org.belisario.adapters.out.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.belisario.adapters.in.entity.SaleEntity;
import org.belisario.application.core.domain.Sale;
import org.belisario.application.ports.out.SaleDBPort;

@ApplicationScoped
public class SaleDBAdapter implements SaleDBPort {

    @Inject
    SaleRepository saleRepository;


    @Override
    public Sale saveSale(Sale sale) {
        SaleEntity saleEntity = SaleEntity.toEntity(sale);
        saleRepository.persist(saleEntity);
        return SaleEntity.toSale(saleEntity);
    }
}
