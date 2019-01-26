package no.poc.domain

import java.io.Serializable

abstract class AbstractEntity<I> : Serializable {

    abstract val id: I
}
