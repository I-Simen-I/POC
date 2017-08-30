package no.poc.domain;

public class KravType {
    private String kravTypeId;
    private String kravTypeNavn;

    public KravType() {
        //JPA
    }

    public KravType(String kravTypeId, String kravTypeNavn) {
        this.kravTypeId = kravTypeId;
        this.kravTypeNavn = kravTypeNavn;
    }

    public String getKravTypeId() {
        return kravTypeId;
    }

    public String getKravTypeNavn() {
        return kravTypeNavn;
    }
}
