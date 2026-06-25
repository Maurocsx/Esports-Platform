package cl.duocuc.esportscoreapi.controller;

import cl.duocuc.esportscoreapi.entity.Plan;
import cl.duocuc.esportscoreapi.entity.Usuario;
import cl.duocuc.esportscoreapi.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoreController {

    @Autowired
    private CoreService coreService;

    @GetMapping("/socios")
    public List<Usuario> obtenerSocios() {
        return coreService.obtenerSocios();
    }

    @GetMapping("/planes")
    public List<Plan> obtenerPlanes() {
        return coreService.obtenerPlanes();
    }
}