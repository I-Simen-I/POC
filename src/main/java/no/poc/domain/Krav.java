package no.poc.domain;

public class Krav extends AbstractEntity<Long> {
    private long kravId;
    private KravType kravType;

    public Krav() {
        //JPA
    }

    public Krav(long kravId, KravType kravType) {
        this.kravId = kravId;
        this.kravType = kravType;
    }

    @Override
    public Long getId() {
        return kravId;
    }

    public long getKravId() {
        return kravId;
    }

    public KravType getKravType() {
        return kravType;
    }
}
