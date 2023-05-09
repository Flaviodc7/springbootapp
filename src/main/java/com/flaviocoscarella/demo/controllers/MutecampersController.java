package com.flaviocoscarella.demo.controllers;

import com.flaviocoscarella.demo.models.Mutecamper;
import com.flaviocoscarella.demo.services.MutecamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class MutecampersController {
    private final MutecamperService mutecamperService;
    public MutecampersController(MutecamperService mutecamperService){
        this.mutecamperService = mutecamperService;

        this.mutecamperService.add(new Mutecamper("one", Math.random()));
        this.mutecamperService.add(new Mutecamper("two", Math.random()));
        this.mutecamperService.add(new Mutecamper("three", Math.random()));
        this.mutecamperService.add(new Mutecamper("four", Math.random()));
        this.mutecamperService.add(new Mutecamper("five", Math.random()));
    }

    @GET
    @Path("/mutecampers")
    @Produces("application/json")
    public List<Mutecamper> showAll(){
        return mutecamperService.getAll();
    }

    @POST
    @Path("/mutecampers")
    public Response addMuteCamper(Mutecamper mutecamper){
        mutecamperService.add(mutecamper);

        return Response.created(
                URI.create("/mutecampers/" + mutecamper.getName())
        ).build();
    }

    @GET
    @Path("/mutecampers/{name}")
    @Produces("application/json")
    public Mutecamper showOne(@PathParam("name") String name){
        return mutecamperService.get(name);
    }
}
