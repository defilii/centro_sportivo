package it.euris.academy.centrosportivo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.enums.Sport;
import it.euris.academy.centrosportivo.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseService courseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetOneCourse() throws Exception {

        Long id = 1L;
        String denomination = "null";
        Sport sport = Sport.Calcio;
        Double price = 1.0;
        String difficulty = "hard";
        Course course = Course
                .builder()
                .id(id)
                .denomination(denomination)
                .sport(sport)
                .price(price)
                .difficulty(difficulty)
                .build();

        List<Course> courses = List.of(course);

        when(courseService.findAll()).thenReturn(courses);

        mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].denomination").value(denomination))
                .andExpect(jsonPath("$[0].sport").value(sport.toString()))
                .andExpect(jsonPath("$[0].price").value(price))
        ;
    }

    @Test
    void shouldGetTestById() throws Exception {

        Long id = 1L;
        String denomination = "null";
        Sport sport = Sport.Calcio;
        Double price = 1.0;
        String difficulty = "hard";
        Course course = Course
                .builder()
                .id(id)
                .denomination(denomination)
                .sport(sport)
                .price(price)
                .difficulty(difficulty)
                .build();

        List<Course> courses = List.of(course);

        when(courseService.findById(id)).thenReturn(course);


        mockMvc.perform(MockMvcRequestBuilders.get("/courses/{id}", id)).
                andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(id))
        ;
    }


    @Test
    void shouldInsertATest() throws Exception {

        Long id = 1L;
        String denomination = "null";
        Sport sport = Sport.Calcio;
        Double price = 1.0;
        String difficulty = "hard";
        Course course = Course
                .builder()
                .id(id)
                .denomination(denomination)
                .sport(sport)
                .price(price)
                .difficulty(difficulty)
                .build();

        when(courseService.insert(any())).thenReturn(course);

        mockMvc.perform(post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(course)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.sport").value(sport.toString()))
                .andExpect(jsonPath("$.denomination").value(denomination));
    }



}
