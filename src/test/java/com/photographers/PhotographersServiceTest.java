package com.photographers;

import com.photographers.dal.entity.EventType;
import com.photographers.dal.entity.Photographers;
import com.photographers.dal.repository.PhotographerRepository;
import com.photographers.service.PhotographersService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PhotographersServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PhotographerRepository photographerRepository;

    private PhotographersService photographersService = new PhotographersService();

    @Test
    public void getAllPhotographersTest() throws Exception {

        List<Photographers> photographersList = new ArrayList<>();
//        Photographers photographers = new Photographers();
//        photographers.setId(100L);
//        photographers.setContact(9876554331L);
//        photographers.setName("Mike");
//        photographers.setEventType(EventType.birthdays);
//        photographersList.add(photographers);
//        Photographers photographers = Photographers.builder().id(100L).contact(9876554331L)
//                                                    .name("John").eventType(EventType.birthdays).build();
//        photographersList.add(photographers);
//        given(photographerRepository.findAll()).willReturn(photographersList);
//        photographersService.getAllPhotographers();
//        Mockito.verify(photographerRepository).findAll();
//        ResultActions response = mockMvc.perform(get("/api/photographers"));
    }

}
