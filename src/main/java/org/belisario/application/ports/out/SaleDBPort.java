package org.belisario.application.ports.out;

import org.belisario.application.core.domain.Sale;

public interface SaleDBPort {

    Sale saveSale(Sale sale);
}
