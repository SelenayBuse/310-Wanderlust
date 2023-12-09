package dev.selenay.wanderlust;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {
    @Autowired
    private MuseumRepository museumRepository;
    public List<Museums> allMuseums(){
        return museumRepository.findAll();
    }

    public Optional<Museums> singleMuseum(ObjectId id){
        return museumRepository.findById(id);
    }
}
