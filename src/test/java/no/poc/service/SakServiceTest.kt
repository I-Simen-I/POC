package no.poc.service

import no.poc.domain.Beskrivelse
import no.poc.domain.builder.BrukerBuilder.aBruker
import no.poc.domain.builder.KravBuilder.aKrav
import no.poc.domain.builder.SakBuilder.aSak
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SakServiceTest {

    companion object {
        private val sakService = SakService()
    }

    @Test
    fun testThatExpectedBeskrivelserIsReturned() {
        val sak = aSak()
                .withSakId(1L)
                .with(aBruker().ofTypeAndebyBruker())
                .with(aKrav().with(Beskrivelse(1, "En")))
                .with(aKrav().with(Beskrivelse(2, "")))
                .with(aKrav().with(Beskrivelse(3, "To")))
                .with(aKrav().with(Beskrivelse(4, "Tre")))
                .with(aKrav().with(Beskrivelse(5, "     ")))
                .with(aKrav().with(Beskrivelse(6, "Fire")))
                .build()

        val findKravbeskrivelser = sakService.findNotEmptyKravbeskrivelser(sak.kravList)
        assertThat(findKravbeskrivelser).hasSize(4)
        assertThat(findKravbeskrivelser[0]).isEqualTo("En")
        assertThat(findKravbeskrivelser[1]).isEqualTo("To")
        assertThat(findKravbeskrivelser[2]).isEqualTo("Tre")
        assertThat(findKravbeskrivelser[3]).isEqualTo("Fire")
    }
}