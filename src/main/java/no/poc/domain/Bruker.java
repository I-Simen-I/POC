package no.poc.domain;

public class Bruker {
    private long brukerId;
    private String fornavn;
    private String etternavn;

    public Bruker() {
        //JPA
    }

    public Bruker(long brukerId, String fornavn, String etternavn) {
        this.brukerId = brukerId;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public long getBrukerId() {
        return brukerId;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }
}
