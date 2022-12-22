package com.app.transfermoney.model;


import com.app.transfermoney.exception.InputDataError;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void testCheckNumberNull() {
        Card card = new Card();
        assertThrows(InputDataError.class, () -> card.checkCardNumber(null));
    }

    @Test
    public void testCheckNumberIncorrect() {
        Card card = new Card();
        assertThrows(InputDataError.class, () -> card.checkCardNumber("1234"));
    }

    @Test
    public void testСheckValidTillNull() {
        Card card = new Card();
        assertThrows(InputDataError.class, () -> card.checkValidTill(null));
    }

    @Test
    public void testСheckValidTillIncorrect() {
        Card card = new Card();
        assertThrows(InputDataError.class, () -> card.checkValidTill("1234"));
    }

    @Test
    public void testСheckValidTillExpiredDate() {
        Card card = new Card();
        assertThrows(InputDataError.class, () -> card.checkValidTill("01/11"));
    }

    @Test
    public void testСheckValidTillIncorrectMonth() {
        Card card = new Card();
        assertThrows(DateTimeParseException.class, () -> card.checkValidTill("15/11"));
    }

    @Test
    public void testCheckCardCVVNull() {
        Card card = new Card();
        assertThrows(InputDataError.class, () -> card.checkCardCVV(null));
    }

    @Test
    public void testCheckCardCVVIncorrect() {
        Card card = new Card();
        assertThrows(InputDataError.class, () -> card.checkCardCVV("1234"));
    }
}