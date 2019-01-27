package no.poc.domain.builder;

import no.poc.domain.Beskrivelse;
import no.poc.domain.Krav;
import no.poc.domain.KravType;

import java.util.Optional;

import static no.poc.domain.builder.TypeBuilder.aBuilderOfType;

public class KravBuilder {
    private long id;
    private TypeBuilder<KravType> kravType;
    private Optional<Beskrivelse> beskrivelse;
    private Optional<BrukerBuilder> bruker;

    private KravBuilder() {
    }

    public static KravBuilder aKrav() {
        return new KravBuilder();
    }

    public KravBuilder withId(long kravId) {
        this.id = kravId;
        return this;
    }

    public KravBuilder with(TypeBuilder<KravType> kravType) {
        this.kravType = kravType;
        return this;
    }

    public KravBuilder with(Beskrivelse beskrivelse) {
        this.beskrivelse = Optional.of(beskrivelse);
        return this;
    }

    public KravBuilder with(BrukerBuilder bruker) {
        this.bruker = Optional.of(bruker);
        return this;
    }

    public Krav build() {
        return new Krav(
                id,
                kravType != null ? kravType.build() : aBuilderOfType(KravType.class).withTypeId("TYPE_1").withName("Type 1").build(),
                beskrivelse != null && beskrivelse.isPresent() ? beskrivelse : Optional.empty(),
                bruker != null && bruker.isPresent() ? Optional.of(bruker.get().build()) : Optional.empty()
        );
    }
}