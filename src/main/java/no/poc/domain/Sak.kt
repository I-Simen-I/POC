package no.poc.domain

data class Sak(
        val id: Long,
        val bruker: Bruker,
        val kravList: List<Krav>
)