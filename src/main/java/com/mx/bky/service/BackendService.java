package com.mx.bky.service;

import com.mx.bky.converter.PokemonConverter;
import com.mx.bky.domain.LocationAreaEncounters;
import com.mx.bky.domain.Peticion;
import com.mx.bky.domain.PokemonTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pokemon.bky.ws.Pokemon;

@Service
public class BackendService {

    @Autowired(required = true)
    private PeticionService peticionService;

    @Autowired
    private HttpServletRequest request;

    String url = "https://pokeapi.co/api/v2/pokemon/";

    List<Pokemon> getPokemonsByName(String name) throws Exception {
        RestTemplate rt = new RestTemplate();
        PokemonTO pokemonTO = rt.getForObject(url + name, PokemonTO.class);
        Pokemon pokemon = new PokemonConverter().convert(pokemonTO);
        saveRequest();
        return Arrays.asList(pokemon);
    }

    String getAbilitiesByName(String name) throws Exception {
        RestTemplate rt = new RestTemplate();
        PokemonTO pokemonTO = rt.getForObject(url + name, PokemonTO.class);
        Pokemon pokemon = new PokemonConverter().convert(pokemonTO);
        saveRequest();
        return pokemon.getAbilities();
    }

    String getBaseExperienceByName(String name) throws Exception {
        RestTemplate rt = new RestTemplate();
        PokemonTO pokemonTO = rt.getForObject(url + name, PokemonTO.class);
        Pokemon pokemon = new PokemonConverter().convert(pokemonTO);
        saveRequest();
        return pokemon.getBaseExperience();
    }

    String getHeldItemsByName(String name) throws Exception {
        RestTemplate rt = new RestTemplate();
        PokemonTO pokemonTO = rt.getForObject(url + name, PokemonTO.class);
        Pokemon pokemon = new PokemonConverter().convert(pokemonTO);
        saveRequest();
        return pokemon.getHeldItems();
    }

    String getIdByName(String name) throws Exception {
        RestTemplate rt = new RestTemplate();
        PokemonTO pokemonTO = rt.getForObject(url + name, PokemonTO.class);
        Pokemon pokemon = new PokemonConverter().convert(pokemonTO);
        saveRequest();
        return pokemon.getId();
    }

    String getLocationAreaEncountersByName(String name) throws Exception {
        RestTemplate rt = new RestTemplate();
        PokemonTO pokemonTO = rt.getForObject(url + name, PokemonTO.class);
        Pokemon pokemon = new PokemonConverter().convert(pokemonTO);
        return getLocationAreaEncounters(pokemon);
    }

    private String getLocationAreaEncounters(Pokemon pokemon) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<List<LocationAreaEncounters>> rateResponse
                = rt.exchange(pokemon.getLocationAreaEncounters(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<LocationAreaEncounters>>() {
                });
        
        List<LocationAreaEncounters> locationAreaEncounters = rateResponse.getBody();
        
        String result = " ";
        
        for (LocationAreaEncounters out : locationAreaEncounters) {
            result = result+ out.getLocation_area().getName().concat(",") ;
        }

        saveRequest();
        
        return result;
    }

    private void saveRequest() {

        Date date = new Date();
        Peticion p = new Peticion();
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        p.setIp(request.getRemoteAddr());
        p.setFechaConsulta(df.format(date));
        p.setMetodo(request.getMethod());
        System.out.println(p.getFechaConsulta());
        peticionService.guardar(p);
        System.out.println(peticionService.listarPeticiones());
    }

}
