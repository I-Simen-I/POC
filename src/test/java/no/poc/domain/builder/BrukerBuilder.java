package no.poc.domain.builder;


import no.poc.domain.Bruker;

public class BrukerBuilder {
    private Long id;
    private String fornavn;
    private String etternavn;
    private String organisasjonsnavn;

    private BrukerBuilder() {
    }

    public static BrukerBuilder aBruker() {
        return new BrukerBuilder();
    }

    public BrukerBuilder withId(long brukerId) {
        this.id = brukerId;
        return this;
    }

    public BrukerBuilder withFornavn(String fornavn) {
        this.fornavn = fornavn;
        this.organisasjonsnavn = null;
        return this;
    }

    public BrukerBuilder withEtternavn(String etternavn) {
        this.etternavn = etternavn;
        this.organisasjonsnavn = null;
        return this;
    }

    public BrukerBuilder withOrganisasjonsnavn(String organisasjonsnavn) {
        this.organisasjonsnavn = organisasjonsnavn;
        this.fornavn = null;
        this.etternavn = null;
        return this;
    }

    public BrukerBuilder ofTypeAndebyBruker() {
        withId(1L);
        withFornavn("Donald");
        withEtternavn("Duck");
        return this;
    }

    public Bruker build() {
        return new Bruker(
                id != null ? id : 1L,
                fornavn,
                etternavn,
                organisasjonsnavn
        );
    }
}
