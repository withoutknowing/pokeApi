package com.mx.bky.converter;

import com.mx.bky.domain.*;
import java.util.ArrayList;
import pokemon.bky.ws.Pokemon;

public class PokemonConverter implements Converter<PokemonTO, Pokemon> {

    @Override
    public Pokemon convert(PokemonTO in) {
        Pokemon out = new Pokemon();
        ArrayList<Abilities> abilitieslist = in.getAbilities();
        ArrayList<HeldItems> heldItemslist = in.getHeld_items();

        String abilities = " ";
        String heldItems = " ";

        for (Abilities a : abilitieslist) {
            abilities = abilities.concat(",") + a.getAbility().getName();
        }

        for (HeldItems h : heldItemslist) {
            heldItems = heldItems.concat(",") + h.getItem().getName();
        }

        out.setAbilities(abilities);
        out.setBaseExperience(in.getBase_experience());
        out.setHeldItems(heldItems);
        out.setId(in.getId());
        out.setLocationAreaEncounters(in.getLocation_area_encounters());
        out.setName(in.getName());

        return out;
    }
}
