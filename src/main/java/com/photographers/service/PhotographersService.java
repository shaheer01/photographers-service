package com.photographers.service;

import com.photographers.dal.entity.EventType;
import com.photographers.dal.entity.Photographers;
import com.photographers.dal.repository.PhotographerRepository;
import com.photographers.exceptions.PhotographersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Cacheable(cacheNames = "photographers")
public class PhotographersService implements Serializable {

    @Autowired
    PhotographerRepository photographerRepository;


    public List<Photographers>  getAllPhotographers(){
        List<Photographers> photographersList = photographerRepository.findAll();

        if(photographersList.size() > 0){
            return photographersList;
        }else {
            return new ArrayList<Photographers>();
        }
    }

    @Cacheable(key = "#id")
    public Photographers getPhotographerById(Long photographersID) throws PhotographersException{
        Optional<Photographers> photographer = photographerRepository.findById(photographersID);

        if(photographer.isPresent()){
            return photographer.get();
        }else {
            throw new PhotographersException("No Photographer record present for the given id", photographersID);
        }
    }

    public List<Photographers> getPhotographersByEventType(String eventType) throws PhotographersException{
        try{
            EventType eventTypes = EventType.valueOf(eventType);
            List<Photographers> photographersList = photographerRepository.findByEventType(eventTypes);

            if(photographersList.size() > 0){
                return photographersList;
            }else {
                return new ArrayList<Photographers>();
            }
        }catch (IllegalArgumentException e){
            throw new PhotographersException("Incorrect event Type", e);
        }

    }
}
