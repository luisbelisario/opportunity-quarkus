package org.belisario.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Sale {

    private Long id;

    private LocalDate date;

    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private Integer tonnes;

    private BigDecimal totalValue;

    public Sale() {
    }

    public Sale(Long id, LocalDate date, Long proposalId, String customer, BigDecimal priceTonne) {
        this.id = id;
        this.date = date;
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public void setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
    }

    public Integer getTonnes() {
        return tonnes;
    }

    public void setTonnes(Integer tonnes) {
        this.tonnes = tonnes;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal calculateTotalValue() {
        return this.priceTonne.multiply(BigDecimal.valueOf(this.tonnes));
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                ", proposalId=" + proposalId +
                ", customer='" + customer + '\'' +
                ", priceTonne=" + priceTonne +
                ", tonnes=" + tonnes +
                ", totalValue=" + totalValue +
                '}';
    }
}
