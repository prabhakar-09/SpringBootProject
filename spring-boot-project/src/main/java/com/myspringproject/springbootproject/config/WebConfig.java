package com.myspringproject.springbootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
        	.parameterName("mediaType")
            .defaultContentType(MediaType.APPLICATION_JSON) // Set the default content type
            .mediaType("json", MediaType.APPLICATION_JSON) // Map the "json" extension to JSON media type
//            also we need to add the dependency in pom.xml file for the XML file type conversion by 
//            default JSON conversion is possible only
            .mediaType("xml", MediaType.APPLICATION_XML); // Map the "xml" extension to XML media type
    }

    // Other configuration methods or beans...
}

