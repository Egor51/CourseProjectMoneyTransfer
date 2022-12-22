package com.app.transfermoney.service;


import com.app.transfermoney.model.Operation;
import com.app.transfermoney.model.Transfer;
import com.app.transfermoney.repository.TransferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferService {

    TransferRepository repository;

    public Transfer saveTransfer(Transfer transfer) {

        return repository.saveTransfer(transfer);
    }

    public Operation confirmTransfer(Operation confirm){

        return repository.confirmTransfer(confirm);
    }

}