package no.poc.service;

import no.poc.domain.Beskrivelse;
import no.poc.domain.Krav;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class SakService {

    public List<String> findNotEmptyKravbeskrivelser(List<Krav> list) {
        return list.stream()
                .map(Krav::getBeskrivelse)
                .flatMap(Optional::stream)
                .map(Beskrivelse::getVerdi)
                .filter(not(String::isBlank))
                .collect(Collectors.toList());
    }
}
