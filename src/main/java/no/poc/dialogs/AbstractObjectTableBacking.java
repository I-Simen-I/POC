package no.poc.dialogs;

import no.poc.domain.AbstractEntity;

import java.util.List;

public abstract class AbstractObjectTableBacking<T extends AbstractEntity<I>, I> extends AbstractInitializeBacking {

    private I scrollToId;
    private List<T> dataList;


    @Override
    public boolean initialized() {
        return dataList != null;
    }

    @Override
    public void load() {

    }
}
