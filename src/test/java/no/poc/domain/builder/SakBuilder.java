package no.poc.domain.builder;

import no.poc.domain.Krav;
import no.poc.domain.Sak;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SakBuilder {
    private long sakId;
    private BrukerBuilder bruker;
    private List<KravBuilder> kravList;

    private SakBuilder() {
    }

    public static SakBuilder aSak() {
        return new SakBuilder();
    }

    public SakBuilder withSakId(long sakId) {
        this.sakId = sakId;
        return this;
    }

    public SakBuilder with(BrukerBuilder bruker) {
        this.bruker = bruker;
        return this;
    }

    public SakBuilder with(KravBuilder krav) {
        if (kravList == null) {
            kravList = new ArrayList<>();
        }

        kravList.add(krav);

        return this;
    }

    public Sak build() {
        return new Sak(
                sakId,
                bruker != null ? bruker.build() : null,
                kravList != null ? convertKravList() : null
        );
    }

    private List<Krav> convertKravList() {
        return kravList.stream().map(KravBuilder::build).collect(toList());
    }
}