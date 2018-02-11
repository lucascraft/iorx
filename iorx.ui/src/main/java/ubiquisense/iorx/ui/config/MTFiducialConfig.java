package ubiquisense.iorx.ui.config;

import java.util.Random;

import javafx.scene.paint.Color;

public class MTFiducialConfig {
	int id;
	int radius;
	String kind;
	int tempo;
	Color fg;
	Color bg;
	int range;
	int weight = 1;

	public MTFiducialConfig(int radius, int tempo) {
		this.id = -1;
		this.radius = radius;
		this.tempo = tempo;
		Random ran = new Random();
		Color c = Color.color(Math.min(0.7, ran.nextDouble()), Math.min(0.5, ran.nextDouble()), Math.min(0.6, ran.nextDouble()));
		this.fg = c;
		this.bg = c;
	}
	
	public MTFiducialConfig(String id, String radius, String kind, String tempo, String fg, String bg, String range, String weight) {
		this.id = Integer.parseInt(id);
		this.radius = Integer.parseInt(radius);
		this.kind = kind;
		this.tempo = Integer.parseInt(tempo);
		this.fg = Color.web(fg);
		this.bg = Color.web(bg);
		this.range = Integer.parseInt(range);
	}
	public int getId() {
		return id;
	}
	public int getRadius() {
		return radius;
	}
	public String getKind() {
		return kind;
	}
	public int getTempo() {
		return tempo;
	}
	public Color getFg() {
		return fg;
	}
	public Color getBg() {
		return bg;
	}
	public int getRange() {
		return range;
	}
	public int getWeight() {
		return weight;
	}
	
}
