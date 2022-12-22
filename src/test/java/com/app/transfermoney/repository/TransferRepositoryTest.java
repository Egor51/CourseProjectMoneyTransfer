package com.app.transfermoney.repository;



import com.app.transfermoney.model.Amount;
import com.app.transfermoney.model.Transfer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransferRepositoryTest {

    @Test
    public void testSaveTransfer() {
        Amount amount = new Amount(12345, "RUB");
        Transfer transferActual = new Transfer("2222222222222222", "12/22", "222",
                "3333333333333333", amount);

        List<Transfer> transferRepositoryActual = new ArrayList<>();
        transferRepositoryActual.add(transferActual);

        TransferRepository transferRepository = new TransferRepository();
        transferRepository.saveTransfer(transferActual);

        assertEquals(transferRepository.getTransferRepository().size(), transferRepositoryActual.size());
    }
}