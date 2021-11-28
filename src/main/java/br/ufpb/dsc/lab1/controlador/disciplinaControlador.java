package br.ufpb.dsc.lab1.controlador;

import br.ufpb.dsc.lab1.entidade.disciplina;
import br.ufpb.dsc.lab1.servico.disciplinaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
public class disciplinaControlador {

    @Autowired
    private disciplinaServico disciplinaService;

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<disciplina> novaDisciplina(@RequestBody disciplina disciplina){
        return new ResponseEntity<disciplina>(disciplinaService.addDisciplina(disciplina), HttpStatus.CREATED);
    }

    @GetMapping("/v1/api/disciplinas")
    public ResponseEntity<List<disciplina>> listarTodas(){
        List<disciplina> disciplinas = disciplinaService.listarTodas();
        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<disciplina> encontrarPorID(@PathVariable int id) {
        try{
            return new ResponseEntity<disciplina>(disciplinaService.encontrarPorId(id),HttpStatus.OK);
        }
        catch (ArrayIndexOutOfBoundsException e){
            return new ResponseEntity<disciplina>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/v1/api/disciplinas/ranking")
    public ResponseEntity<List<disciplina>> rankingDisciplinas(){
        try{
            return new ResponseEntity<List<disciplina>>(disciplinaService.ordenarPelaNota(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<disciplina> alterarNome(@PathVariable int id, @RequestBody disciplina disciplina){
        disciplina.setId(id);
        try {
            return new ResponseEntity<disciplina>(disciplinaService.alterarNome(disciplina), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<disciplina>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<disciplina> alterarNota (@PathVariable int id, @RequestBody disciplina disciplina){
        disciplina.setId(id);
        try {
            return new ResponseEntity<disciplina>(disciplinaService.alterarNota(disciplina), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<disciplina>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Void> removerDisciplina(@PathVariable int id){
        try {
            disciplinaService.removerDisciplinaPorId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}