import ea.*;

/**
 * Dieses Spiel-Projekt demonstriert die Verwendung der Maus
 * und die standardmäßigen Möglichkeiten, die sich damit
 * bieten.
 * @author andonie
 *
 */
public class Spiel 
extends Game 
implements KlickReagierbar, RechtsKlickReagierbar {

	/**
	 * Die Maus, die man im Spiel sehen wird.
	 */
	private Maus maus;
	
	/**
	 * Der Konstruktor der Klasse Spiel.
	 * Hier wird das Spiel initialisiert.
	 */
	public Spiel() {
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
		
		maus.klickReagierbarAnmelden(this);
		maus.rechtsKlickReagierbarAnmelden(this);
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
	 * Diese Methode wird bei jedem Rechtsklick aufgerufen.
	 * 
	 * Bei einem Rechtsklick wird dann ein kleiner, blauer Kreis auf den Klick-Punkt
	 * gesetzt.
	 * 
	 * @param punkt	Der Punkt, der die Position des Klicks auf der Zeichenebene beschreibt.
	 */
	@Override
	public void rechtsKlickReagieren(Punkt punkt) {
		
		//Erstelle einen neuen Kreis (durchmesser = 20 px). Die Position ist hier egal.
		Kreis kreis = new Kreis (0,0, 20);
		//setze die Farbe auf Blau.
		kreis.farbeSetzen("Blau");
		
		//setze den Mittelpunkt des Kreises auf den Klick-Punkt.
		kreis.mittelpunktSetzen(punkt);
		
		//Mache den Kreis sichtbar: An Wurzel anmelden.
		wurzel.add(kreis);
	}

	
	/**
	 * Diese Methode wird bei jedem Linksklick aufgerufen.
	 * 
	 * Bei einem Linksklick wird ein rotes Rechteck auf den Klick-Punkt gesetzt.
	 */
	@Override
	public void klickReagieren(Punkt punkt) {

		//Erstelle ein neues Rechteck (Maße: 30 x 50 px). Die Position ist hier egal.
		Rechteck rechteck = new Rechteck(0,0, 30, 50);
		//setze die Farbe auf Rot
		rechteck.farbeSetzen("Rot");
		
		//setze den Mittelpunkt des Kreises auf den Klick-Punkt
		rechteck.mittelpunktSetzen(punkt);
		
		//Mache das Rechteck sichtbar: An Wurzel anmelden.
		wurzel.add(rechteck);
	}
	
	
	
	/**
	 * Main Methode. Hiermit kann man die Demo starten.
	 * @param args	Eingabeparameter
	 */
	public static void main(String[] args) {
		new Spiel();
	}
}
