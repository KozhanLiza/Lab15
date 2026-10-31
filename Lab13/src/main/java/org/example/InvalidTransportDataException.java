package org.example;

// Checked-исключение для неверных данных транспорта
class InvalidTransportDataException extends Exception {
    public InvalidTransportDataException(String message) {
        super(message);
    }
}
