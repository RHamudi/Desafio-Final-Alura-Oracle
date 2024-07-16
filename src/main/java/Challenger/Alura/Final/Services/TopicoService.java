package Challenger.Alura.Final.Services;

import Challenger.Alura.Final.DTO.DadosRepostaTopico;
import Challenger.Alura.Final.Domain.Curso;
import Challenger.Alura.Final.DTO.DadosAdicionarTopico;
import Challenger.Alura.Final.Domain.Topico;
import Challenger.Alura.Final.Domain.Usuario;
import Challenger.Alura.Final.Repository.CursoRepository;
import Challenger.Alura.Final.Repository.TopicoRepository;
import Challenger.Alura.Final.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TopicoService implements IService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity PegarTodos(){
        return ResponseEntity.ok().body(topicoRepository.findAll());
    }

    @Transactional
    public ResponseEntity Adicionar(DadosAdicionarTopico dados){
        Validar(dados);

        Usuario autor = usuarioRepository.getReferenceById(dados.user_id());
        Curso curso = cursoRepository.getReferenceById(dados.curso_id());
        Topico novoTopico = new Topico(dados.titulo(), dados.mensagem(), curso, autor);

        novoTopico = topicoRepository.save(novoTopico);

        return ResponseEntity.ok().body(new DadosRepostaTopico(novoTopico));
    }

    @Transactional
    public ResponseEntity PegarUnico(Long id){
        var topico = topicoRepository.findById(id);

        return ResponseEntity.ok().body(topico);
    }

    @Transactional
    public ResponseEntity Atualizar(Long id, DadosAdicionarTopico topico){
        Topico findTopico = topicoRepository.findById(id).orElseThrow(() -> new ValidationException("Não foi possivel encontrar um Topico"));

        Validar(topico);

        Curso curso = cursoRepository.findById(topico.curso_id()).get();
        Usuario user = usuarioRepository.findById(topico.user_id()).get();
        findTopico.setTitulo(topico.titulo());
        findTopico.setMensagem(topico.mensagem());
        findTopico.setCurso(curso);
        findTopico.setAutor(user);
        topicoRepository.save(findTopico);

        return ResponseEntity.ok().body(findTopico);
    }

    public ResponseEntity DeletarComId(Long id){
        try{
            Topico topico = topicoRepository.getReferenceById(id);
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex){
            return ResponseEntity.noContent().build();
        }
    }

    public void Validar(DadosAdicionarTopico dados) {
        if(!cursoRepository.existsById(dados.curso_id())){
            throw new ValidationException("Curso não encontrado");
        }

        if(topicoRepository.existsByTitulo(dados.titulo())){
            throw new ValidationException("Já existe um topico com esse nome");
        }

    }
}
