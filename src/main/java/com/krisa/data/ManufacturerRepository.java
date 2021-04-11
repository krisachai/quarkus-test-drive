package com.krisa.data;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ManufacturerRepository implements PanacheRepositoryBase<Manufacturer, Long> {

}
