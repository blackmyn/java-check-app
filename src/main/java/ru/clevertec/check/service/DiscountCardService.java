package ru.clevertec.check.service;

import ru.clevertec.check.model.DiscountCard;
import ru.clevertec.check.util.CsvReader;

import java.io.IOException;
import java.util.List;

public class DiscountCardService {
    private final CsvReader<DiscountCard> discountCardFileReader;

    public DiscountCardService(CsvReader<DiscountCard> discountCardFileReader) {
        this.discountCardFileReader = discountCardFileReader;
    }

    public void printDiscountCardsFromCsv(String filePath) {
        try {
            List<DiscountCard> discountCards = discountCardFileReader.read(filePath);
            discountCards.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}