package view.dialogs;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

import localization.Language;
import view.window.MyMainFrame;

public class HelpDialog extends JDialog{
	
	private static HelpDialog instance = null;

	public static HelpDialog getInstance() {
		if (instance == null) {
			instance = new HelpDialog();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	private JTextArea text;
	
	private HelpDialog() {
		
		setTitle(Language.getInstance().getResourceBundle().getString("help"));
		setSize(1920, 1080);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(false);
		
		centerPanel = new JPanel();
		text = new JTextArea("#Meni bar\r\n"
				+ "U meni baru imamo sledece stavke: File, Edit i Help.\r\n"
				+ "-File ima sledece stavke: New, Save i Open\r\n"
				+ "New sluzi za dodavanje novo entiteta.\r\n"
				+ "Save sluzi za cuvanje entiteta.\r\n"
				+ "Open sluzi za otvaranje odredjene tabele.\r\n"
				+ "-Edit ima sledece stavke: Edit i delete.\r\n"
				+ "Edit sluzi za izmjenu entiteta.\r\n"
				+ "Delete sluzi za brisanje entiteta.\r\n"
				+ "-Help ima sledece stavke Help i About\r\n"
				+ "Help sluzi za pomoc korisnicima pri koriscenju aplikacije.\r\n"
				+ "About nam daje vise informacija o aplikaciji.\r\n"
				+ "\r\n"
				+ "#Toolbar\r\n"
				+ "Toolbar nam sluzi za dodavanje, izmjenu, brisanje i pretragu entiteta.\r\n"
				+ "\r\n"
				+ "#Status Bar\r\n"
				+ "U status baru imamo prikazan naziv aplikacije, trenutni otvoreni tab, "
				+ "\\r\\nkao i trenutno vrijeme i datum.\r\n"
				+ "\r\n"
				+ "#Dodavanje novog entiteta\r\n"
				+ "Novi entitet mozemo dodati preko toolbara, dugmeta New u meni baru ili "
				+ "\\r\\npreko odgovarajucih akceleratora i mnemonika. Pritiskom na neko od tih dugmadi "
				+ "\\r\\notvara se dijalog za dodavanje novog entiteta.\r\n"
				+ "\r\n"
				+ "#Izmjena entiteta\r\n"
				+ "Entitet mozemo izmjeniti pritiskom na edit dugme u toolbaru, edit dugme u meni "
				+ "\\r\\nbaru, kao i koriscenjem odgovarajucih mnemonika i akceleratora. Pritiskom na neko "
				+ "\\r\\nod tih dugmadi otvara se dijalog za izmjenu odgovarajuceg entiteta\r\n"
				+ "\r\n"
				+ "#Brisanje entiteta\r\n"
				+ "Entitet mozemo obrisati pritiskom na edit dugme u toolbaru, delete dugme u meni baru, "
				+ "\\r\\nkao i koriscenjem odgovarajucih mnemonika i akceleratora, tako sto izaberemo odgovarajuci "
				+ "\\r\\nentitet i klinemo na neko od gorenavedenih dugmadi.\r\n"
				+ "\r\n"
				+ "#Prikaz polozenih ispita\r\n"
				+ "Klikom na tab polozeni u dijalogu za izmjenu studenta prikazuju nam se sve ocjene "
				+ "\\r\\nodgovarajuceg studenta\r\n"
				+ "\r\n"
				+ "#Ponistavanje ocjene studenta\r\n"
				+ "Izborom ocjene i pritiskom dugmeta ponisti ocjenu, ocjena se ponistava.\r\n"
				+ "\r\n"
				+ "#Prikaz nepolozenih ispita\r\n"
				+ "Izborom taba nepolozeni ispiti dijaloga za editovanje studenata prikazuje se lista "
				+ "\\r\\nnepolozenih ispita odgovarajuceg studenta.\r\n"
				+ "\r\n"
				+ "#Dodavanje studenta na predmet\r\n"
				+ "Klikom dugmeta dodaj koje se nalazi u tabu nepolozeni ispiti dijaloga za editovane "
				+ "\\r\\nstudenata mozemo da dodamo studenta na odgovarajuce predmete.\r\n"
				+ "\r\n"
				+ "#Uklanjanje studenta sa predemeta\r\n"
				+ "Klikom dugmeta ukloni koje se nalazi u tabu nepolozeni ispiti dijaloga za editovane "
				+ "\\r\\nstudenata mozemo da uklonimo studenta sa odgovarajuceg predmeta.\r\n"
				+ "\r\n"
				+ "#Upis ocjene studentu\r\n"
				+ "Klikom na dugme polaganje koje se nalazi u tabu nepolozeni ispiti dijaloga za editovanje "
				+ "\\r\\nstudenata moguce je dodjeliti studentu ocjenu na tom predmetu, pa se samim tim taj predemet"
				+ " \\r\\nsmatra polozenim.\r\n"
				+ "\r\n"
				+ "#Pretraga entiteta\r\n"
				+ "Koriscenje polja za unos teksta koje se nalazi u toolbaru moguce je vrsiti pretragu "
				+ "\\r\\nodgovarajucih entiteta.\r\n"
				+ "\r\n"
				+ "#Sortiranje entiteta\r\n"
				+ "Koriscenjem strelica koje se nalaze pored naziva kolona u tabelama moguce je vrsiti sortiranje"
				+ "\\r\\n tabele po elementima iz te kolone.\r\n"
				+ "\r\n"
				+ "#Prikaz predmeta koje profesor predaje\r\n"
				+ "Izborom taba predmeti dijaloga za editovanje profesora, prikazuju se svi predmeti koje profesor"
				+ "\\r\\n predaje u tom trenutku.\r\n"
				+ "\r\n"
				+ "#Dodavanje predmeta profesoru\r\n"
				+ "Klikom na dugme dodaj predemet prikazuje se dijalog sa svim predemtima koje profesor moze da "
				+ "\\r\\npredaje. Odabirom predmeta i klikom na dugme potvrdi dodaje se predmet profesoru.\r\n"
				+ "\r\n"
				+ "#Uklanjanje predmeta iz liste predmeta, koje profesor predaje \r\n"
				+ "Odabirom odgovarajuceg predemta iz liste prekdmeta koje profesor predaje i klikom na dugme ukloni "
				+ "\\r\\npredemet, predmet se uklanja iz liste predmeta koje profesor predaje.\r\n"
				+ "\r\n"
				+ "#Dodavanje profesora na predmet\r\n"
				+ "Izborom odgovarajuceg predmeta iz liste predemta i klikom na dugme edit, prikazuje nam se dijalog "
				+ "\\r\\nza izmjenu predemta. U okviru tog dijaloga imamo dugme za dodavanje profesora na predemet. Klikom "
				+ "\\r\\nna to dugme prikazuje nam se lista profesora koje mozemo dodati na predmet.\r\n"
				+ "\r\n"
				+ "#Uklanjanje profesora sa predemta\r\n"
				+ "Klikom na dugme minus koje se nalazi u dijalogu za izmjenu predemta moguce je ukloniti profesora "
				+ "\\r\\nsa predmeta.\r\n"
				+ "\r\n"
				+ "#Postavljanje sefa katedre\r\n"
				+ "Sve departmane koji se nalaze u sistemu je moguce prikazati klikom dugmeta Katedre koje se nalazi "
				+ "\\r\\nu meni baru. Izborom odgovarajuce katedre i klikom na dugme Izmjena sefa katedre moguce je izmjeniti "
				+ "\\r\\nsefa katedre.\r\n"
				+ "\r\n"
				+ "#Lokalizacija\r\n"
				+ "Klikom na dugme Jezik koje se nalazi u meni baru moguce je odabrati jezik na kojem ce se prikazivati "
				+ "\\r\\naplikacija.\"");
		text.setEditable(false);
		JScrollPane jsp = new JScrollPane(text);
		centerPanel.add(jsp);
		add(centerPanel);
		
	}
	
}
