package no.poc.domain.builder;

import no.poc.domain.Bruker;

public class BrukerBuilder {
    private long brukerId;
    private String fornavn;
    private String etternavn;

    private BrukerBuilder() {
    }

    public static BrukerBuilder aBruker() {
        return new BrukerBuilder();
    }

    public BrukerBuilder withBrukerId(long brukerId) {
        this.brukerId = brukerId;
        return this;
    }

    public BrukerBuilder withFornavn(String fornavn) {
        this.fornavn = fornavn;
        return this;
    }

    public BrukerBuilder withEtternavn(String etternavn) {
        this.etternavn = etternavn;
        return this;
    }

    public BrukerBuilder ofTypeAndebyBruker() {
        withBrukerId(1L);
        withFornavn("Donald");
        withEtternavn("Duck");
        return this;
    }

    public Bruker build() {
        return new Bruker(brukerId, fornavn, etternavn);
    }
}
