package no.poc.domain

data class Bruker(
        val id: Long,
        val fornavn: String?,
        val etternavn: String?,
        val organisasjonsnavn: String?
) {
    fun isBedrift(): Boolean {
        return fornavn.isNullOrBlank()
                .and(etternavn.isNullOrBlank())
                .and(organisasjonsnavn.isNullOrBlank().not())
    }
}