package no.poc.domain;

import java.io.Serializable;

public abstract class AbstractEntity<I> implements Serializable {

    public abstract I getId();
}
