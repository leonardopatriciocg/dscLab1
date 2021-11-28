package br.ufpb.dsc.lab1.servico;

import br.ufpb.dsc.lab1.entidade.disciplina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class disciplinaServico {

    private final List<disciplina> disciplinas = new ArrayList<>();

    public disciplina addDisciplina(disciplina novaDisciplina){
        novaDisciplina.setId(disciplinas.size()+1);
        disciplinas.add(novaDisciplina);
        return disciplinas.get(disciplinas.size()-1);
    }
    public List<disciplina> listarTodas(){
        if(disciplinas.isEmpty()) throw new ArrayIndexOutOfBoundsException();
        return disciplinas;
    }
    public disciplina encontrarPorId(int id){
        if (disciplinas.isEmpty() || id < 0 || id >= disciplinas.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return  disciplinas.get(id-1);
    }

    public disciplina alterarNome (disciplina disciplina){
        disciplina atualizarNome = encontrarPorId(disciplina.getId());
        if (atualizarNome != null) {
            atualizarNome.setNome(disciplina.getNome());
        }
        disciplinas.set(disciplina.getId()-1, atualizarNome);
        return atualizarNome;
    }

    public disciplina alterarNota(disciplina disciplina){
        disciplina atualizarNota = encontrarPorId(disciplina.getId());
        if(atualizarNota != null){
            atualizarNota.setNota(disciplina.getNota());
        }
        disciplinas.set(disciplina.getId()-1, atualizarNota);
        return atualizarNota;
    }

    public void removerDisciplinaPorId(int id){
        for (disciplina d : disciplinas){
            if (d.getId() == id){
                disciplinas.remove(id);
                break;
            }
        }
    }
    public List<disciplina> ordenarPelaNota(){
        Collections.sort(disciplinas, (o1, o2) -> {
            if(o1.getNota() > o2.getNota()) return -1;
            if(o1.getNota() < o2.getNota()) return +1;
            else return 0;
        });
        return disciplinas;
    }

}