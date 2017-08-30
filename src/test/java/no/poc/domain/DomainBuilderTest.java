package no.poc.domain;

import org.junit.Test;

import static no.poc.domain.builder.BrukerBuilder.aBruker;
import static no.poc.domain.builder.KravBuilder.aKrav;
import static no.poc.domain.builder.SakBuilder.aSak;
import static no.poc.domain.builder.TypeBuilder.aBuilderOfType;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DomainBuilderTest {
    @Test
    public void buildDomain() {
        Sak sak = aSak()
                .withSakId(1L)
                .with(aBruker().ofTypeAndebyBruker())
                .with(aKrav()
                        .withKravId(1L)
                        .with(aBuilderOfType(KravType.class).withTypeId("TYPE_1").withName("Type 1"))
                )
                .with(aKrav()
                        .withKravId(2L)
                        .with(aBuilderOfType(KravType.class).withTypeId("TYPE_2").withName("Type 2"))
                )
                .build();

        assertThat(sak.getSakId(), is(1L));
        assertThat(sak.getBruker().getBrukerId(), is(1L));
        assertThat(sak.getBruker().getFornavn(), is("Donald"));
        assertThat(sak.getBruker().getEtternavn(), is("Duck"));
        assertThat(sak.getKravList().size(), is(2));
        assertThat(sak.getKravList().get(0).getKravId(), is(1L));
        assertThat(sak.getKravList().get(0).getKravType().getKravTypeId(), is("TYPE_1"));
        assertThat(sak.getKravList().get(0).getKravType().getKravTypeNavn(), is("Type 1"));
        assertThat(sak.getKravList().get(1).getKravId(), is(2L));
        assertThat(sak.getKravList().get(1).getKravType().getKravTypeId(), is("TYPE_2"));
        assertThat(sak.getKravList().get(1).getKravType().getKravTypeNavn(), is("Type 2"));
    }
}