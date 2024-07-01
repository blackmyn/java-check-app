package ru.clevertec.check.service;

import ru.clevertec.check.model.Product;
import ru.clevertec.check.util.CsvReader;

import java.io.IOException;
import java.util.List;

public class ProductService {
    private final CsvReader<Product> productFileReader;

    public ProductService(CsvReader<Product> productFileReader) {
        this.productFileReader = productFileReader;
    }

    public void printProductsFromCsv(String filePath) {
        try {
            List<Product> products = productFileReader.read(filePath);
            products.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}