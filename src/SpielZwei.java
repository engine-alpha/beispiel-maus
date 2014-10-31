import ea.Bild;
import ea.Game;
import ea.KlickReagierbar;
import ea.Kreis;
import ea.Maus;
import ea.MausBewegungReagierbar;
import ea.Punkt;
import ea.Rechteck;
import ea.RechtsKlickReagierbar;
import ea.Vektor;

/**
 * Dieses Spiel-Projekt demonstriert die Verwendung der Maus
 * und die standardmäßigen Möglichkeiten, die sich damit
 * bieten.
 * @author andonie
 *
 */
public class SpielZwei 
extends Game 
implements MausBewegungReagierbar {

	/**
	 * Die Maus, die man im Spiel sehen wird.
	 */
	private Maus maus;
	
	/**
	 * Ein Kreis. Die Maus wird diesen Kreis bewegen.
	 */
	private Kreis kreis;
	
	/**
	 * Der Konstruktor der Klasse Spiel.
	 * Hier wird das Spiel initialisiert.
	 */
	public SpielZwei() {
		//Fenstermaße 500 x 500 Pixel
		super(500,500);
		
		//Maus erstellen und ins Spiel einbinden.
		maus = new Maus(
				//Das Bild für den Cursor
				new Bild(0,0, "fadenkreuz.gif"),
				//Der Punkt, der den Hotspot relativ zum Mausbild angibt.
				//Für dieses Bild macht der Punkt (12,12) relativ zum Mausbild Sinn.
				new Punkt(11, 11));
		mausAnmelden(maus);
		
		//MausBewegungReagierbar - Interface an der Maus anmelden
		maus.mausBewegungReagierbarAnmelden(this);
		
		//Den Kreis erstellen, einfärben und sichtbar machen (an Wurzel anmelden)
		kreis = new Kreis(200,200, 100);
		kreis.farbeSetzen("Rot");
		wurzel.add(kreis);
	}
	
	/**
	 * Diese Methode wird immer aufgerufen, wenn die Maus vom Spieler bewegt wird.
	 * 
	 * Die Bewegung der Maus wird umgekehrt auf den Kreis im Fenster übertragen.
	 */
	@Override
	public void mausBewegt(Vektor bewegung) {
		kreis.verschieben(bewegung.gegenrichtung());
	}
	
	/**
	 * Taste-Reagieren-Methode. Wird hier nicht gebraucht, da wir nur die Maus verwenden.
	 * @param code Der Tasten-Code der runtergedrückten Taste.
	 */
	@Override
	public void tasteReagieren(int code) {
		//Nichts zu tun.
	}
	
	/**
	 * Main Methode. Hiermit kann man die Demo starten.
	 * @param args	Eingabeparameter
	 */
	public static void main(String[] args) {
		new SpielZwei();
	}
}
