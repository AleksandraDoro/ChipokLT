package org.example.service;

import org.example.utils.QueryTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductService {

    private static final String MOCK1_URL = "http://localhost:8081/api/mock01";
    private static final String MOCK2_URL = "http://localhost:8082/api/mock02";
    private final JdbcTemplate jdbcTemplate;
    private static
    // накопить heap и вызвать out of memory!

    @Autowired
    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //    Получение информации о запрошенном товаре.
    public String getItemInfo(String requestedItem) {
        List<String> price = isItemAvailable(requestedItem);
        if (!price.isEmpty()) {
            return price.get(0);
        } else {
            if (callMock1().equals("true")) {
                // Выполняем GET запрос к mock2
                try {
                return new RestTemplate().getForObject(MOCK2_URL, String.class);
                } catch (Exception e) {
                    return "Ошибка при выполнении запроса к mock2";
                }
            } else {
                return "Такого не завезли. И не завезут. Совсем зажрались!";
            }
        }
    }

    // Метод для проверки наличия запрошенного продукта в базе данных
    public List<String> isItemAvailable(String item) {
        return jdbcTemplate.query(QueryTypes.SELECTPRICE.getQuery(),
                new Object[]{item},
                (rs, rowNum) -> rs.getString("price"));
          // Если список не пустой, значит, товар доступен
    }

    // Метод для выполнения запроса к MOCK1
    public String callMock1() {
        try {
            return new RestTemplate().getForObject(MOCK1_URL, String.class);
        } catch (Exception e) {
            return "Ошибка при выполнении запроса к mock1";
        }
    }
}