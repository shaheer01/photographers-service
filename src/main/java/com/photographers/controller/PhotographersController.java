package com.photographers.controller;

import com.photographers.dal.entity.Photographers;
import com.photographers.service.PhotographersService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class PhotographersController {

    @Autowired
    PhotographersService photographersService;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Events Successfully pushed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error")})
    @RequestMapping(path = "/photographers", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Photographers>> photographers(){
        List<Photographers> photographers = photographersService.getAllPhotographers();
        return new ResponseEntity<List<Photographers>>(photographers, HttpStatus.OK);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Events Successfully pushed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error")})
    @RequestMapping(path = "/photographers/{photographerID}", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Photographers> photographersById(@ApiParam(value = "photographer ID",
            required = true) @PathVariable("photographerID") Long photographerID){
        Photographers photographers = photographersService.getPhotographerById(photographerID);
        return new ResponseEntity<Photographers>(photographers, HttpStatus.OK);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Events Successfully pushed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error")})
    @RequestMapping(path = "/photographers/event/{eventType}", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Photographers>> photographersByEventType(@ApiParam(value = "Event Type",
            required = true) @PathVariable("eventType") String eventType){
        List<Photographers> photographers = photographersService.getPhotographersByEventType(eventType);
        return new ResponseEntity<List<Photographers>>(photographers, HttpStatus.OK);
    }
}
