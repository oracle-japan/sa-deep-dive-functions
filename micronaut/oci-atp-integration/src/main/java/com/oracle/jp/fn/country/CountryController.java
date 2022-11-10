package com.oracle.jp.fn.country;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author shukawam
 */
@Controller("/country")
public class CountryController {

    private final CountryRepository countryRepository;

    @Inject
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountry() {
        final List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        return countryList;
    }

    @Get("/id/{countryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountryByCountryId(String countryId) {
        final Optional<Country> optionalCountry = countryRepository.findById(countryId);
        if (optionalCountry.isEmpty()) {
            throw new NotFoundException();
        }
        return optionalCountry.get();
    }
}
