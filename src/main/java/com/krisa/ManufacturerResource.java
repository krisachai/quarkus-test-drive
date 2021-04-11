package com.krisa;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.krisa.data.Manufacturer;
import com.krisa.data.ManufacturerRepository;

import org.jboss.logging.Logger;

@Path("/manufacturer")
public class ManufacturerResource {
    private static final Logger LOG = Logger.getLogger(ManufacturerResource.class);
    @Inject
    ManufacturerRepository mr;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long manufacturerId) {
        return Response.ok(mr.findById(manufacturerId)).build();
    }

    @GET
    public Response findAll(@DefaultValue("") @QueryParam("name") String name) {
        return Response.ok(mr.find("name like ?1", "%" + name + "%").list()).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(@Valid Manufacturer manufacturer) {
        LOG.info(manufacturer);
        mr.persist(manufacturer);
        return Response.ok(manufacturer).status(Status.CREATED).build();
    }
}
