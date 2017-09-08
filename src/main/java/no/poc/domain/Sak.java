package no.poc.domain;

import java.util.List;

public class Sak extends AbstractEntity<Long> {
    private long sakId;
    private Bruker bruker;
    private List<Krav> kravList;

    public Sak() {
        //JPA
    }

    public Sak(long sakId, Bruker bruker, List<Krav> kravList) {
        this.sakId = sakId;
        this.bruker = bruker;
        this.kravList = kravList;
    }

    @Override
    public Long getId() {
        return sakId;
    }

    public long getSakId() {
        return sakId;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public List<Krav> getKravList() {
        return kravList;
    }
}
