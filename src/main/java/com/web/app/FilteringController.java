package com.web.app;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {


    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("v1", "v2", "v3");

        //filter out field 3 and only allow field1 and field2 in the response


        //creating the filter
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        //creating the return mapping with the filter
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeanList(){
        return Arrays.asList(new SomeBean("v1","v2","v3"), new SomeBean("b1","b2","b3"));
    }
}
