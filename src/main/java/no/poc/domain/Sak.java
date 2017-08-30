package no.poc.domain;

import java.util.List;

public class Sak {
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
