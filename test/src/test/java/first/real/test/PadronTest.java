package first.real.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import src.Padron;
import src.Persona;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class PadronTest {
    static Padron padron= new Padron();
    static     ArrayList<Persona> personas;
    public PadronTest() {}

    @BeforeClass
    public static void cargarPadronEjemplo() throws Exception {

     personas = new ArrayList<>();

        Persona p1 = new Persona("Juan","26.150.235","1979-01-01",42,true);
        Persona p2 = new Persona("Pedro","27.280.234","1980-02-01",41,true);
        Persona p3 = new Persona("Maria","28.184.259","1981-03-01",47,true);
        Persona p4 = new Persona("Cecilia","32.234.528","1983-04-01",38,true);
        Persona p5= new Persona("Carlos","33.124.235","1985-04-01",36,true);
        Persona p6 = new Persona("Jose","35.345.534","1987-04-01",34,true);

        padron.AddVotante(p1);
        padron.AddVotante(p2);
        padron.AddVotante(p3);
        padron.AddVotante(p4);
        padron.AddVotante(p5);
        padron.AddVotante(p6);

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);


        //System.out.println(padron.getPartipantes().size());
    }

    /*@Test
    public void testAgregarVotante() {
        int cantVotantesAntes=padron.getPartipantes().size();
        padron.AddVotante(new Persona("Fermin","45.321.456", "2002-10-10",22, true));
        int cantVotantesDespues=padron.getPartipantes().size();
        Assert.assertEquals("Error son diferentes",cantVotantesAntes+1,cantVotantesDespues);

    }*/

    @Test
    public void testExistePersona(){
        /*System.out.println(personas);*/
        Persona pepe = new Persona("Pepe","34.345.532","1987-04-01",34,true);
        personas.add(pepe);
        for (Persona persona : personas) {
            Assert.assertNotEquals(persona,pepe);
        }
    }
}