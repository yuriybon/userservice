package ua.odessa.bondar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@NamedNativeQuery(
        name = "history_qvr",
        query = "select VENDOR_NAME, COUNTRY, CITY, STREET table(pkg_address.get_agg_address(cursor(select * from address order by vendor_name),:p_country))"
)

@Entity
public class Address {

    public static final String HIST_QVR = "history_qvr";

    @Id
    @Column(name = "VENDOR_NAME")
    private String vendorName;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
}
