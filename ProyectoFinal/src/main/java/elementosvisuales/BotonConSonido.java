package elementosvisuales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
/**
 * Clase que crea ub boton capaz de reproducir musica
 * @author Antonio Jesus
 */
public class BotonConSonido extends JButton {
	//File con la ruta del archivo de la musica
	private File musica;
	//Clip para poder poner y parar la musica
	private Clip clip;
	//audioInputStream para que pueda llehar a sonar la musica
	private AudioInputStream audioInputStream;
	/**
	 * Constructor para crear el boton con musica
	 * @param m para pasarle el mensaje que le queramos poner al boton
	 */
	public BotonConSonido(String m) {
		super(m);
		final Timer timer = new Timer();
		setEnabled(true);
		//Seleccionamos la ruta de la musica
		musica = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "/./musica.wav");

		BotonConSonido.this.addActionListener(new ActionListener() {

			@Override
			//Con esta funcion, hacemos que mientras siga en la misma pantalla, solo se pueda pulsar una vez para que no se distorsione el sonido
			public void actionPerformed(ActionEvent e) {

				play();

				setEnabled(false);

			}

		});

	}

	/**
	 * Metodo para reproducir un archivo de audio
	 */
	public void play() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(musica);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.err.println(e);
		}
	}

}