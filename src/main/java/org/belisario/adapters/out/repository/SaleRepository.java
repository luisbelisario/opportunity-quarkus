package org.belisario.adapters.out.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.belisario.adapters.in.entity.SaleEntity;

@ApplicationScoped
public class SaleRepository implements PanacheRepository<SaleEntity> {
}
