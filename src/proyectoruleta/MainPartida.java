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
                Ruleta ruleta = Ruleta.getRuleta();
                ruleta.jugarPartida();
        }

        public static void main(String[] args)
        {
                instancia.jugarPartida();
        }
}
