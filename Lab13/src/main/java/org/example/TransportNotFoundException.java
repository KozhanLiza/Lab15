package org.example;

// Unchecked-исключение, если транспорт не найден
class TransportNotFoundException extends RuntimeException {
    public TransportNotFoundException(String message) {
        super(message);
    }
}
