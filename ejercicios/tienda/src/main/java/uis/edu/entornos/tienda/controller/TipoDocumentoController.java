package uis.edu.entornos.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import uis.edu.entornos.tienda.model.TipoDocumento;
import uis.edu.entornos.tienda.service.TipoDocumentoService;

@RestController
public class TipoDocumentoController {
    @Autowired
    TipoDocumentoService tipoDocumentoService;
    
    /**
     * Se obtiene la lista de tipos de documento
     * 
     * @return lista de tipos de documento
     */
    @Operation(summary = "Obtiene todos los tipos de documento")
    @GetMapping("/list/tipoDocumentos")
    public List<TipoDocumento> getTiposDocumento() {
        return tipoDocumentoService.getTipoDocumentos();
    }

    /**
     * Se obtiene un tipo de documento por su id
     * 
     * @param id id del tipo de documento
     * @return tipo de documento
     */
    @Operation(summary = "Obtiene un tipo de documento por su id")
    @GetMapping("/list/tipoDocumentos/{id}")
    public ResponseEntity<TipoDocumento> findById(@PathVariable Long id) {
        return tipoDocumentoService.findTipoDocumentoById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Se crea un nuevo tipo de documento
     * 
     * @param tipoDocumento tipo de documento a crear
     * @return tipo de documento creado
     */
    @Operation(summary = "Crea un tipo documento")
    @PostMapping("/tipoDocumentos")
    public ResponseEntity<TipoDocumento> newTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return ResponseEntity.ok(tipoDocumentoService.newTipoDocumento(tipoDocumento));
    }

    /**
     * Se actualiza un tipo de documento
     * 
     * @param tipoDocumento tipo de documento a actualizar
     * @return tipo de documento actualizado
     */
    @Operation(summary = "Actualiza un tipo de documento")
    @PutMapping("/tipoDocumentos")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        Optional<TipoDocumento> tipoDocumentoUpdated = tipoDocumentoService.findTipoDocumentoById(tipoDocumento.getId());
        if (tipoDocumentoUpdated != null) {
            return ResponseEntity.ok(tipoDocumentoService.newTipoDocumento(tipoDocumento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Se elimina un tipo de documento
     * 
     * @param id id del tipo de documento a eliminar
     * @return tipo de documento eliminado
     */
    @Operation(summary = "Elimina un tipo de documento")
    @DeleteMapping("/tipoDocumentos/{id}")
    public ResponseEntity<TipoDocumento> deleteTipoDocumento(@PathVariable Long id) {
        Optional<TipoDocumento> tipoDocumento = tipoDocumentoService.findTipoDocumentoById(id);
        if (tipoDocumento != null) {
            tipoDocumentoService.deleteTipoDocumento(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
