package proyectoruleta;

public class MainPartida
{
        private static MainPartida instancia = new MainPartida();

        private MainPartida(){}

        public MainPartida getMainPartida()
        {
                return instancia;
        }

        public void jugarPartida() {
                System.out.println("|======================================|");
        		System.out.println("|====== ¡Bienvenido a la Ruleta! ======|");
        		System.out.println("|======================================|\n");
        		Ruleta ruleta = Ruleta.getRuleta();
                ruleta.jugarPartida();
        }

        public static void main(String[] args)
        {
                instancia.jugarPartida();
        }
}
