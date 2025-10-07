package com.github.chore.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)

public class SellerApproveStatusMessage extends NotAcceptableStatusException {
    public SellerApproveStatusMessage(String reason) {
        super(reason);
    }

}
