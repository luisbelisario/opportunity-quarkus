package org.belisario.adapters.in.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.belisario.application.core.domain.Sale;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sale")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    private LocalDate date;

    @Column(name = "proposal_id")
    private Long proposalId;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    private Integer tonnes;

    private BigDecimal totalValue;

    public static SaleEntity toEntity(Sale sale) {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setDate(sale.getDate());
        saleEntity.setProposalId(sale.getProposalId());
        saleEntity.setCustomer(sale.getCustomer());
        saleEntity.setPriceTonne(sale.getPriceTonne());
        saleEntity.setTonnes(sale.getTonnes());
        saleEntity.setTotalValue(sale.calculateTotalValue());
        return saleEntity;
    }

    public static Sale toSale(SaleEntity saleEntity) {
        Sale sale = new Sale();
        sale.setId(saleEntity.getId());
        sale.setDate(saleEntity.getDate());
        sale.setProposalId(saleEntity.getProposalId());
        sale.setCustomer(saleEntity.getCustomer());
        sale.setPriceTonne(saleEntity.getPriceTonne());
        sale.setTonnes(saleEntity.getTonnes());
        sale.setTotalValue(saleEntity.calculateTotalValue());
        return sale;
    }

    public BigDecimal calculateTotalValue() {
        return this.priceTonne.multiply(BigDecimal.valueOf(this.tonnes));
    }
}
