package no.poc.domain

import java.util.*

data class Krav(
        val id: Long,
        val kravType: KravType,
        val beskrivelse: Optional<Beskrivelse> = Optional.empty(),
        val bruker: Optional<Bruker> = Optional.empty()
)
