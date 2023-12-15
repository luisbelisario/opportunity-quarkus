package org.belisario.application.ports.in;

import org.belisario.application.core.domain.Proposal;
public interface IncomingMessagePort {



    public void receiveProposal(Proposal proposal);

}
