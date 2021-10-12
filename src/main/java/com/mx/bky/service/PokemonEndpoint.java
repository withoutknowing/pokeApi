package com.mx.bky.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.*;


import pokemon.bky.ws.*;

@Slf4j
@Endpoint
@RequiredArgsConstructor
public class PokemonEndpoint {

    private final BackendService backendService;
    private final String nameSpace="http://ws.bky.pokemon/";
    private final String error="no se encuentra el pokémon, favor de consultar: https://www.pokemon.com/el/pokedex/ ";

    @PayloadRoot(namespace = nameSpace, localPart = "PokemonByNameRequest")
    @ResponsePayload
    public PokemonsResponse getPokemonsByName(@RequestPayload PokemonByNameRequest parameters) {
        PokemonsResponse pokemonsResponse = new PokemonsResponse();
        try {
            pokemonsResponse.getPokemon().addAll(backendService.getPokemonsByName(parameters.getName()));
        } catch (Exception e) {
            log.error("Error while setting values for pokemon object", e);
        }
        return pokemonsResponse;
    }

    @PayloadRoot(namespace = nameSpace, localPart = "Abilities")
    @ResponsePayload
    public AbilitiesResponse getAbilitiesByName(@RequestPayload Abilities parameters) {
        AbilitiesResponse abilitiesResponse = new AbilitiesResponse();
        try {
            abilitiesResponse.setAbility(backendService.getAbilitiesByName(parameters.getName()));

        } catch (Exception e) {
            log.error("Error while setting values for pokemon object", e);
            abilitiesResponse.setAbility(error);
        }
        return abilitiesResponse;
    }

    @PayloadRoot(namespace = nameSpace, localPart = "BaseExperience")
    @ResponsePayload
    public BaseExperienceResponse getBaseExperienceByName(@RequestPayload BaseExperience parameters) {
        BaseExperienceResponse baseExperienceResponse = new BaseExperienceResponse();
        try {
            baseExperienceResponse.setBaseExperience(backendService.getBaseExperienceByName(parameters.getName()));
        } catch (Exception e) {
            log.error("Error while setting values for pokemon object", e);
            baseExperienceResponse.setBaseExperience(error);
        }
        return baseExperienceResponse;
    }

    @PayloadRoot(namespace = nameSpace, localPart = "HeldItems")
    @ResponsePayload
    public HeldItemsResponse getHeldItemsByName(@RequestPayload HeldItems parameters) {
        HeldItemsResponse heldItemsResponseResponse = new HeldItemsResponse();
        try {
            heldItemsResponseResponse.setHeldItems(backendService.getHeldItemsByName(parameters.getName()));
        } catch (Exception e) {
            log.error("Error while setting values for pokemon object", e);
            heldItemsResponseResponse.setHeldItems(error);
        }
        return heldItemsResponseResponse;
    }

    @PayloadRoot(namespace = nameSpace, localPart = "IdPokemon")
    @ResponsePayload
    public IdPokemonResponse getIdByName(@RequestPayload IdPokemon parameters) {
        IdPokemonResponse IdResponse = new IdPokemonResponse();
        try {
            IdResponse.setIdPokemon(backendService.getIdByName(parameters.getName()));
        } catch (Exception e) {
            log.error("Error while setting values for pokemon object", e);
            IdResponse.setIdPokemon(error);
        }
        return IdResponse;
    }

    @PayloadRoot(namespace = nameSpace, localPart = "LocationAreaEncounters")
    @ResponsePayload
    public LocationAreaEncountersResponse getLocationAreaEncountersByName(@RequestPayload LocationAreaEncounters parameters) {
        LocationAreaEncountersResponse locationAreaEncountersResponse = new LocationAreaEncountersResponse();
        try {
            locationAreaEncountersResponse.setLocationAreaEncounters(backendService.getLocationAreaEncountersByName(parameters.getName()));
        } catch (Exception e) {
            log.error("Error while setting values for pokemon object", e);
            locationAreaEncountersResponse.setLocationAreaEncounters(error);
        }
        return locationAreaEncountersResponse;
    }

}
