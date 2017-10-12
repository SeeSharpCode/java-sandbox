package com.sandbox.springbootbatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

// A common paradigm in batch processing is to ingest data, transform it, and then pipe it out somewhere else.
// Here you write a simple transformer that converts the names to uppercase.
// This class implements ItemProcessor which makes it easy to wire the code into a batch job. The type arguments
// define the input and output type.
@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception {
        final String transformedLastName = person.getLastName().toUpperCase();
        final String transformedFirstName = person.getFirstName().toUpperCase();

        final Person transformedPerson = new Person(transformedLastName, transformedFirstName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
