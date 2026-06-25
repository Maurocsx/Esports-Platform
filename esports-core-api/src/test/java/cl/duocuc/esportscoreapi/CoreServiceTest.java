package cl.duocuc.esportscoreapi;

import cl.duocuc.esportscoreapi.entity.Plan;
import cl.duocuc.esportscoreapi.entity.Usuario;
import cl.duocuc.esportscoreapi.repository.PlanRepository;
import cl.duocuc.esportscoreapi.repository.UsuarioRepository;
import cl.duocuc.esportscoreapi.service.CoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoreServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PlanRepository planRepository;

    @InjectMocks
    private CoreService coreService;

    @Test
    void obtenerSocios_retornaListaDeUsuarios() {
        Plan plan = new Plan(1L, "Plan Pro - Valorant");

        Usuario usuario = new Usuario(
                1L,
                "socio_premium",
                "clave123",
                "socio.premium@duocuc.cl",
                plan
        );

        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

        List<Usuario> resultado = coreService.obtenerSocios();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("socio_premium", resultado.get(0).getUsername());

        verify(usuarioRepository).findAll();
    }

    @Test
    void obtenerPlanes_retornaListaDePlanes() {
        Plan plan = new Plan(1L, "Plan Amateur - League of Legends");

        when(planRepository.findAll()).thenReturn(List.of(plan));

        List<Plan> resultado = coreService.obtenerPlanes();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Plan Amateur - League of Legends", resultado.get(0).getNombre());

        verify(planRepository).findAll();
    }
}