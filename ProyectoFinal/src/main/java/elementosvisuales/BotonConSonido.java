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

public class BotonConSonido extends JButton {
	private File musica;
	private Clip clip;
	private AudioInputStream audioInputStream;

	public BotonConSonido(String m) {
		super(m);
		final Timer timer = new Timer();
		setEnabled(true);
		musica = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "/./musica.wav");

		BotonConSonido.this.addActionListener(new ActionListener() {

			@Override
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