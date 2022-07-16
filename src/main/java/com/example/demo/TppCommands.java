package com.example.demo;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDate;

import static org.springframework.shell.standard.ShellOption.NULL;

@ShellComponent
public class TppCommands {

    @ShellMethod("Initiate a payment. Once done it can be authorized - see mobile commands.")
    public String payment(
            @ShellOption(defaultValue = NULL) LocalDate requestedExecutionDate,
            @ShellOption(defaultValue = "0.01") String amount,
            @ShellOption(defaultValue = "EUR") String currency,
            @ShellOption(value = "--creditor-iban", defaultValue = "FR7619553000010000000000142") String creditorIban,
            @ShellOption boolean creditorReferenceStructured,
            @ShellOption(defaultValue = NULL) String creditorReferenceValue
    ) {
        return String.format("iban=%s, date=%s structure=%s", creditorIban, requestedExecutionDate, creditorReferenceStructured);
    }

    @ShellMethod("Get information about a single Account")
    public String account(
            @ShellOption(defaultValue = NULL ) String iban,
            @ShellOption boolean withBalance) {
        return String.format("iban=%s, with-balance=%s", iban, withBalance);
    }

}
