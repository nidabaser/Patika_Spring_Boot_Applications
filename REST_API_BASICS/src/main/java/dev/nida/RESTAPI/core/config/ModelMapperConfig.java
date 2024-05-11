package dev.nida.RESTAPI.core.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nida Başer
 * May 2024
 */

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        // Eşleştirme stratejisini biraz daha esnek yap, işte camel case'leri, birbirine benzeyenleri göz ardı et gibi...
        return modelMapper;
    }

}
