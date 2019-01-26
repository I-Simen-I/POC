package no.poc.domain

import java.util.*

data class Sak(val sakId: Long, val bruker: Bruker, val kravList: List<Krav>? = Collections.emptyList())