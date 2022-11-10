package com.oracle.jp.fn.country;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity(name = "Country")
public class Country {

    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    /**
     * @return the countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the countryId to set
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
