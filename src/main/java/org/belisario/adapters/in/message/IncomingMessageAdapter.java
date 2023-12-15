package org.belisario.adapters.in.message;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.belisario.application.core.domain.Proposal;
import org.belisario.application.core.domain.Sale;
import org.belisario.application.core.service.SaleServicePort;
import org.belisario.application.ports.in.IncomingMessagePort;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class IncomingMessageAdapter implements IncomingMessagePort {

    private final Logger LOG = LoggerFactory.getLogger(IncomingMessageAdapter.class);

    @Inject
    SaleServicePort saleServicePort;

    @Override
    @Incoming("proposal")
    @Transactional
    public void receiveProposal(Proposal proposal) {
        LOG.info("Recebendo nova proposta aprovada pelo Kafka!");
        Sale sale = saleServicePort.saveSaleFromProposal(proposal);
        LOG.info("Nova venda salva! " + sale.toString());
    }
}
