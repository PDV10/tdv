package first.real.test;

import org.junit.*;
import src.Persona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class PersonaTest {

    static Persona ejemplos[];
    static Persona casoActual;
    static Persona buCasoActual;

    @BeforeClass
    public static void cargarEjemplos() throws Exception {
        ejemplos= new Persona[6];
        System.out.println("comienza test de personas mayores de 16 años inclusive");

        ejemplos[0] = new Persona("Juan","26.150.235","1979-01-01",23,true);
        ejemplos[1]  = new Persona("Pedro","27.280.234","1980-02-01",41,true);
        ejemplos[2]  = new Persona("Maria","28.184.259","1981-03-01",47,true);
        ejemplos[3]  = new Persona("Cecilia","32.234.528","1983-04-01",38,true);
        ejemplos[4] = new Persona("Carlos","33.124.235","1985-04-01",36,true);
        ejemplos[5]  = new Persona("Jose","35.345.534","1987-04-01",34,true);
    }


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("finalizo el test correctamente");
    }


    @Before
    public void elegirUno() throws Exception {
        //generador de numeros aleatorios
        Random generadorAleatorios = new Random();
        //genera un numero entre 1 y 5 y lo guarda en la variable numeroAleatorio
        int numeroAleatorio = generadorAleatorios.nextInt(PersonaTest.ejemplos.length);
        casoActual=ejemplos[numeroAleatorio];
        //  buCasoActual= clone(casoActual)

    }

    @Test
    public void tesHabilitadoParaVotar() {


        for (Persona actual : ejemplos) {
            boolean obtenido = actual.isHabilitadoParaVotar();
            boolean esperado = actual.getEdad()>=16;
            Assert.assertEquals(obtenido, esperado);
        }
        System.out.println("\n");
    }

    @Test
    public void testSetEdad() throws ParseException {
        Persona persona = ejemplos[0];
     /*   casoActual.setFechaNacimiento("2000-10-08");*/
        persona.setFechaNacimiento("2000-10-08");
        int edadReportada = persona.getEdad();
        int edadReal= getEdad(persona.getFechaNacimiento());
        System.out.println("edad reportada: " + edadReportada);
        System.out.println("edad real: " +edadReal);
        Assert.assertTrue(edadReportada == edadReal);
        //Assert.assertTrue("Fallo en el calculo de la edad",edadReportada == edadReal);
    }

    public int getEdad(String fechaNacimiento) throws ParseException {
        try {
            // Crea un objeto SimpleDateFormat para parsear la fecha de nacimiento.
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Parsea la fecha de nacimiento.
            Date fechaNac = sdf.parse(fechaNacimiento);

            // Obtiene la fecha actual.
            Date fechaActual = new Date();

            // Crea un objeto Calendar para calcular la diferencia entre las fechas.
            Calendar calNac = Calendar.getInstance();
            Calendar calActual = Calendar.getInstance();
            calNac.setTime(fechaNac);
            calActual.setTime(fechaActual);

            // Calcula la diferencia de años.
            int edad = calActual.get(Calendar.YEAR) - calNac.get(Calendar.YEAR);

            // Verifica si el cumpleaños ya pasó este año.
            if (calNac.get(Calendar.MONTH) > calActual.get(Calendar.MONTH) ||
                    (calNac.get(Calendar.MONTH) == calActual.get(Calendar.MONTH) &&
                            calNac.get(Calendar.DAY_OF_MONTH) > calActual.get(Calendar.DAY_OF_MONTH))) {
                edad--;
            }

            return edad;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1; // Manejo de errores
        }
    }

}