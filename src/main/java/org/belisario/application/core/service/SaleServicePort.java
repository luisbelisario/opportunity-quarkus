package org.belisario.application.core.service;

import org.belisario.application.core.domain.Proposal;
import org.belisario.application.core.domain.Sale;

import java.util.List;

public interface SaleServicePort {

    Sale saveSaleFromProposal(Proposal proposal);

    List<Sale> getSales();

    Sale getSaleById(Long id);
}
