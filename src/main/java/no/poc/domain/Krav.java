package no.poc.domain;

public class Krav {
    private long kravId;
    private KravType kravType;

    public Krav() {
        //JPA
    }

    public Krav(long kravId, KravType kravType) {
        this.kravId = kravId;
        this.kravType = kravType;
    }

    public long getKravId() {
        return kravId;
    }

    public KravType getKravType() {
        return kravType;
    }
}
