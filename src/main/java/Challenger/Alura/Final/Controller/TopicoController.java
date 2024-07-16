package Challenger.Alura.Final.Controller;

import Challenger.Alura.Final.DTO.DadosAdicionarTopico;
import Challenger.Alura.Final.Repository.TopicoRepository;
import Challenger.Alura.Final.Services.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TopicoService service;

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deleteById(@RequestHeader("Authorization") String token, @PathVariable Long id){
        return service.DeletarComId(id, token);
    }

    @PostMapping("/editar/{id}")
    @Transactional
    public ResponseEntity putById(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestBody @Valid DadosAdicionarTopico topico){
        return service.Atualizar(id, topico, token);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getById(@PathVariable Long id){
        return service.PegarUnico(id);
    }

    @PostMapping
    @Transactional
    public  ResponseEntity add(@RequestHeader("Authorization") String token,@RequestBody @Valid DadosAdicionarTopico dados){
        return service.Adicionar(dados, token);
    }

    @GetMapping
    public ResponseEntity getAll(){
        return service.PegarTodos();
    }
}
