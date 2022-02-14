import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {
    @Test
    public void bonusIgualZeroParaFuncionariosComSalarioAlto(){
        BonusService service = new BonusService();
        //assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000"))));
        try{
            service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception!");
        }catch (Exception e){
            assertEquals("Funcionario com salario maior que R$10.000 não pode receber bonus", e.getMessage());
        }
    }

    @Test
    public void bonusDezPorcentoParaFuncionariosComSalarioAlto(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void bonusDezPorcentoParaSalarioDeDezMil(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
