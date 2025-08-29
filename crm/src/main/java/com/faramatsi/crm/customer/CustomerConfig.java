package com.faramatsi.crm.customer;

import com.faramatsi.crm.complaint.Complaint;
import com.faramatsi.crm.feedback.Feedback;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class CustomerConfig implements CommandLineRunner  {

    CustomerRepository repository;

    public CustomerConfig(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer trey = new Customer(
             "Trey",
             "Songs",
             "trey@gmail.com",
             "263784431080",
             "Harare, Borrowdale",
                LocalDate.of(1996,11,14),
                null,
                null
        );
        Customer kim = new Customer(
                "Kim",
                "Jong ung",
                "kimj@gmail.com",
                "263774567831",
                "XoXo, South Korea",
                LocalDate.of(1975,7,19),
                null,
                null
        );
        repository.saveAll(List.of(trey,kim));
    }
}
