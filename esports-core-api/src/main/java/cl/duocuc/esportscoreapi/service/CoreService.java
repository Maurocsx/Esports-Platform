package cl.duocuc.esportscoreapi.service;

import cl.duocuc.esportscoreapi.entity.Plan;
import cl.duocuc.esportscoreapi.entity.Usuario;
import cl.duocuc.esportscoreapi.repository.PlanRepository;
import cl.duocuc.esportscoreapi.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanRepository planRepository;

    public List<Usuario> obtenerSocios() {
        return usuarioRepository.findAll();
    }

    public List<Plan> obtenerPlanes() {
        return planRepository.findAll();
    }

    @PostConstruct
    public void cargarDatosPrueba() {
        if (planRepository.count() == 0) {

            Plan planAmateur = planRepository.save(
                    new Plan(null, "Plan Amateur - League of Legends"));

            Plan planPro = planRepository.save(
                    new Plan(null, "Plan Pro - Valorant"));

            usuarioRepository.save(
                    new Usuario(null,
                            "socio_premium",
                            "clave123",
                            "socio.premium@duocuc.cl",
                            planPro));

            usuarioRepository.save(
                    new Usuario(null,
                            "socio_estudiante",
                            "clave456",
                            "socio.estudiante@duocuc.cl",
                            planAmateur));

            System.out.println("¡DATOS DE PRUEBA LIMPIOS CARGADOS EN MYSQL!");
        }
    }
}