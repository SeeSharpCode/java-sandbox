package com.sandbox.springboottransactions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class BookingService {
    // Starting with Spring 4.3, if a class, which is configured as a Spring bean, has only one constructor,
    // the Autowired annotation can be omitted and Spring will use that constructor and inject all necessary dependencies.
    private final JdbcTemplate jdbcTemplate;

    public BookingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // This method is tagged with @Transactional, meaning that any failure causes the entire operation to roll back to
    // its previous state, and to re-throw the original exception. This means that none of the people will be
    // added to BOOKINGS if one person fails to be added.
    @Transactional
    public void book(String... persons) {
        for (String person : persons) {
            log.info("Booking " + person + " in a seat...");
            jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)", person);
        }
    }

    public List<String> findAllBookings() {
        return jdbcTemplate.query("select FIRST_NAME from BOOKINGS",
                (rs, rowNum) -> rs.getString("FIRST_NAME"));
    }
}
