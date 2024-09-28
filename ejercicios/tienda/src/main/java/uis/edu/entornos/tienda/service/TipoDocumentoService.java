package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.tienda.model.TipoDocumento;
import uis.edu.entornos.tienda.repository.TipoDocumentoRepository;

@Service
@Transactional
public class TipoDocumentoService implements ITipoDocumentoService {
    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> getTipoDocumentos() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumento newTipoDocumento(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public Optional<TipoDocumento> findTipoDocumentoById(Long id) {
        return tipoDocumentoRepository.findById(id);
    }

    @Override
    public void deleteTipoDocumento(Long id) {
        tipoDocumentoRepository.deleteById(id);
        return;
    }

}
