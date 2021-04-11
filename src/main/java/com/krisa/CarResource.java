package com.krisa;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import com.krisa.data.*;
import com.krisa.utils.PageRequest;
import com.krisa.utils.PagedResponse;

import org.jboss.logging.Logger;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

@Path("/car")
public class CarResource {
    private static final Logger LOG = Logger.getLogger(CarResource.class);
    @Inject
    CarRepository cr;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long carId) {
        return cr.findByIdOptional(carId).map(car -> {
            return Response.ok(car).build();
        }).orElse(Response.ok().status(Status.NOT_FOUND).build());
    }

    @GET
    @Path("/manufacturer/{id}")
    public Response findByManufacturerId(@PathParam("id") long manufacturerId) {
        // Test if panache can handle `in`
        List<Long> ids = new ArrayList<>();
        ids.add(manufacturerId);
        return Response.ok(cr.find("manufactureid in ?1", ids).list()).build();
    }

    @GET
    public Response findAll(@BeanParam @Valid PageRequest page, @DefaultValue("") @QueryParam("name") String name) {

        PanacheQuery<Car> cars = cr.find("model like ?1", "%" + name + "%");
        cars.page(Page.of(page.getPage(), page.getSize()));

        return Response.ok(new PagedResponse<Car>(cars)).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(@Valid Car car) {

        cr.persist(car);

        LOG.info(car.getManufacturer());

        return Response.ok(car).status(Status.CREATED).build();
    }
}
