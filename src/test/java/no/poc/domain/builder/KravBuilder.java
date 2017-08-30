package no.poc.domain.builder;

import no.poc.domain.Krav;
import no.poc.domain.KravType;

public class KravBuilder {
    private long kravId;
    private TypeBuilder<KravType> kravType;

    private KravBuilder() {
    }

    public static KravBuilder aKrav() {
        return new KravBuilder();
    }

    public KravBuilder withKravId(long kravId) {
        this.kravId = kravId;
        return this;
    }

    public KravBuilder with(TypeBuilder<KravType> kravType) {
        this.kravType = kravType;
        return this;
    }

    public Krav build() {
        return new Krav(
                kravId,
                kravType != null ? kravType.build() : null
        );
    }
}