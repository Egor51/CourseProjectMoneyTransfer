package com.app.transfermoney.controller;


import com.app.transfermoney.exception.InputDataError;
import com.app.transfermoney.exception.TransferError;
import com.app.transfermoney.model.Confirmation;
import com.app.transfermoney.model.Operation;
import com.app.transfermoney.model.Transfer;
import com.app.transfermoney.service.TransferService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor

public class TransferController {
    private static final Logger LOG = LogManager.getLogger(TransferController.class);


    TransferService transferService;

    @PostMapping("/transfer")
    @CrossOrigin(origins = "*")
    public Operation save(@RequestBody Transfer transfer) {
        Transfer sendTransfer = transferService.saveTransfer(transfer);
        String msg = String.format("Id транзакии: %s, Карта отправителя = %s, Карта получателя = %s, Информация о переводе = %s",
                sendTransfer.getOperationId(),transfer.getCardFrom(), transfer.getCardTo(), transfer.getAmount());
        LOG.info(msg);
        return sendTransfer.getOperationId();
    }


    @PostMapping("/confirmOperation")
    @CrossOrigin(origins = "*")
    public Operation confirm(@RequestBody Confirmation confirmOperation) {
        String code = confirmOperation.getCode();
        if (code == null || code.isEmpty()) {
            throw new TransferError("Код подтверждения не заполнен.");
        }
        String msg = String.format("Подтверждение операции %s с кодом %s",
                confirmOperation.getOperationId(), confirmOperation.getCode());
        LOG.info(msg);
        return transferService.confirmTransfer(confirmOperation.getOperationId());
    }


    @ExceptionHandler(InputDataError.class)
    public ResponseEntity<String> errorInputDataHandler(InputDataError e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransferError.class)
    public ResponseEntity<String> errorTransferHandler(TransferError e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}