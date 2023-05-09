package com.flaviocoscarella.demo.services;

import com.flaviocoscarella.demo.models.Mutecamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MutecamperService {
    private final List<Mutecamper> Mutecampers = new ArrayList<>();
    public List<Mutecamper> getAll(){
        return Mutecampers;
    }

    public void add(Mutecamper mutecamper){
        Mutecampers.add(mutecamper);
    }

    public Mutecamper get(String name){
        for (Mutecamper mutecamper : Mutecampers.toArray(new Mutecamper[0])){
            if (mutecamper.getName().equalsIgnoreCase(name)){
                return mutecamper;
            }
        }
        return null;
    }
}
