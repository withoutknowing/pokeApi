package com.mx.bky.service;

import com.mx.bky.domain.Peticion;
import java.util.List;


public interface PeticionService {

    public List<Peticion> listarPeticiones();

    public void guardar(Peticion peticion);

    public void eliminar(Peticion peticion);

    public Peticion encontrarPeticion(Peticion peticion);

}
