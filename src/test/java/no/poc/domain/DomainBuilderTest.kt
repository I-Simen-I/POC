package no.poc.domain

import no.poc.domain.builder.BrukerBuilder.aBruker
import no.poc.domain.builder.KravBuilder.aKrav
import no.poc.domain.builder.SakBuilder.aSak
import no.poc.domain.builder.TypeBuilder.aBuilderOfType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainBuilderTest {

    @Test
    fun buildDomain() {
        val sak = aSak()
                .withSakId(1L)
                .with(aBruker().ofTypeAndebyBruker())
                .with(aKrav()
                        .withId(1L)
                        .with(aBuilderOfType(KravType::class.java).withTypeId("TYPE_1").withName("Type 1"))
                )
                .with(aKrav()
                        .withId(2L)
                        .with(aBuilderOfType(KravType::class.java).withTypeId("TYPE_2").withName("Type 2"))
                        .with(aBruker().withId(2L).withOrganisasjonsnavn("Bedrift AS"))
                )
                .build()

        assertThat(sak.bruker.id).isEqualTo(1L)
        assertThat(sak.bruker.fornavn).isEqualTo("Donald")
        assertThat(sak.bruker.etternavn).isEqualTo("Duck")

        assertThat(sak.kravList).hasSize(2)

        assertThat(sak.kravList[0].id).isEqualTo(1L)
        assertThat(sak.kravList[0].kravType.kravTypeId).isEqualTo("TYPE_1")
        assertThat(sak.kravList[0].kravType.kravTypeNavn).isEqualTo("Type 1")
        assertThat(sak.kravList[0].bruker).isEmpty

        assertThat(sak.kravList[1].id).isEqualTo(2L)
        assertThat(sak.kravList[1].kravType.kravTypeId).isEqualTo("TYPE_2")
        assertThat(sak.kravList[1].kravType.kravTypeNavn).isEqualTo("Type 2")
        assertThat(sak.kravList[1].bruker).isPresent
        assertThat(sak.kravList[1].bruker.get().organisasjonsnavn).isEqualTo("Bedrift AS")
        assertThat(sak.kravList[1].bruker.get().isBedrift()).isTrue()
    }
}