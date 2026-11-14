package com.example.springloja.controller;

import com.example.springloja.dto.VendaDTO;
import com.example.springloja.entities.Cliente;
import com.example.springloja.entities.Venda;
import com.example.springloja.services.VendaService;
import com.example.springloja.services.StorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/vendas")
@CrossOrigin
@Tag(name="Vendas", description = "Gerenciamento de vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @Autowired
    private StorageService storageService;

    @GetMapping
    @Operation(summary = "Lista todas as vendas", description = "Retorna uma lista completa de vendas")
    public List<Venda> listar() {
        return service.listarTodas();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String salvar(@Valid @RequestPart Venda venda) {
        service.salvar(venda);
        return "Venda salva com sucesso!";
    }

    @PutMapping(value ="/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String atualizar(@PathVariable Long id,@Valid @RequestBody Venda venda){
        venda.setId(id);
        service.atualizar(venda);
        return "Venda atualizada com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        service.excluir(id);
        return "Venda deletada com sucesso!";
    }

    @GetMapping("/filtro-preco")
    public List<VendaDTO> filtrarPorValor(@RequestParam(name="valor") Double valor) {
        return service.buscarPorValorMaximo(valor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Long id){
        Venda obj = service.buscarPorId(id);

        if (obj != null){
            return ResponseEntity.ok().body(obj);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
