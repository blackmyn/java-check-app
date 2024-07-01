package ru.clevertec.check.util;

import ru.clevertec.check.model.DiscountCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiscountCardFileReader extends CsvReader<DiscountCard> {
    @Override
    public List<DiscountCard> read(String filePath) throws IOException {
        List<DiscountCard> discountCards = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int number = Integer.parseInt(values[1]);
                int discountAmount = Integer.parseInt(values[2]);

                DiscountCard discountCard = new DiscountCard(id, number, discountAmount);
                discountCards.add(discountCard);
            }
        }
        return discountCards;
    }
}

