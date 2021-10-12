package com.mx.bky.service;

import com.mx.bky.dao.PeticionDAO;
import com.mx.bky.domain.Peticion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeticionServiceImpl implements PeticionService {

    @Autowired
    private PeticionDAO peticionDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Peticion> listarPeticiones() {
        return (List<Peticion>) peticionDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Peticion peticion) {
        peticionDao.save(peticion);
    }

    @Override
    @Transactional
    public void eliminar(Peticion peticion) {
        peticionDao.delete(peticion);
    }

    @Override
    @Transactional(readOnly = true)
    public Peticion encontrarPeticion(Peticion peticion) {
        return peticionDao.findById(peticion.getId()).orElse(null);
    }
}

