package dev.selenay.wanderlust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumService {
    @Autowired
    private MuseumRepository museumRepository;
    public List<Museums> allMuseums(){
        return museumRepository.findAll();
    }
}
