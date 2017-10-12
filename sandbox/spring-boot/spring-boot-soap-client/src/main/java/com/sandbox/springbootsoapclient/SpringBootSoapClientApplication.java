package com.sandbox.springbootsoapclient;

import hello.wsdl.GetQuoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringBootSoapClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(QuoteClient quoteClient) {
		return args -> {
			String ticker = "MSFT";

			if (args.length > 0) {
				ticker = args[0];
			}

			GetQuoteResponse response = quoteClient.getQuote(ticker);
			log.info(response.getGetQuoteResult());
		};
	}
}
