package com.mx.bky.domain;

import java.util.ArrayList;
import lombok.Data;

@Data
public class PokemonTO {

  private ArrayList<Abilities> abilities;
  private String base_experience;  
  private ArrayList<HeldItems> held_items;
  private String id;
  private String name;
  private String location_area_encounters;
 
}