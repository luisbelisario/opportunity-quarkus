package org.belisario.application.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.belisario.application.core.domain.Proposal;
import org.belisario.application.core.domain.Sale;
import org.belisario.application.ports.out.SaleDBPort;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class SaleService implements SaleServicePort {

    @Inject
    SaleDBPort saleDBPort;

    @Override
    public Sale saveSaleFromProposal(Proposal proposal) {
        Sale sale = buildSaleFromProposal(proposal);
        return saleDBPort.saveSale(sale);
    }

    @Override
    public List<Sale> getSales() {
        return null;
    }

    @Override
    public Sale getSaleById(Long id) {
        return null;
    }

    private Sale buildSaleFromProposal(Proposal proposal) {
        Sale sale = new Sale();
        sale.setProposalId(proposal.getProposalId());
        sale.setCustomer(proposal.getCustomer());
        sale.setDate(LocalDate.now());
        sale.setPriceTonne(proposal.getPriceTonne());
        sale.setTonnes(proposal.getTonnes());
        sale.setTotalValue(sale.calculateTotalValue());
        return sale;
    }

}
