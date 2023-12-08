package dev.selenay.wanderlust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    public List<Hotels> allHotels(){
        return hotelRepository.findAll();
    }
}
