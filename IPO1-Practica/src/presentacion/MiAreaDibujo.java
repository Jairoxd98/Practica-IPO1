package presentacion;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JLabel;

public class MiAreaDibujo extends JLabel {
	private ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();

	public MiAreaDibujo() {
	}

	void addObjetoGrafico(ObjetoGrafico objg) {
		objetosGraficos.add(objg);
	}

	public ObjetoGrafico getUltimoObjetoGrafico() {
		return objetosGraficos.get(objetosGraficos.size() - 1);
	}
	
	public void removeAll() {
		this.objetosGraficos = new ArrayList<ObjetoGrafico>();
	}
	
	public void removeObjetoGrafico(int x, int y) {
		for (int i = objetosGraficos.size() - 1; i >= 0; i--) {
			ObjetoGrafico objg = objetosGraficos.get(i);
			if (objg instanceof ImagenGrafico) {

				if (Math.abs((x - objg.getX())) <= 15 && Math.abs((y - objg.getY())) <= 15) {
					objetosGraficos.remove(i);
					break;
				}
			} else if (objg instanceof LineaGrafica) {
				if ((Math.abs((x - objg.getX())) <= 15 && Math.abs((y - objg.getY())) <= 15)
						|| (Math.abs((x - ((LineaGrafica) objg).getX1())) <= 15
								&& Math.abs((y - ((LineaGrafica) objg).getY1())) <= 15)) {
					
					objetosGraficos.remove(i);
					break;
				}
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		for (int i = 0; i < objetosGraficos.size(); i++) {
			ObjetoGrafico objg = objetosGraficos.get(i);
			if (objg instanceof ImagenGrafico)
			{
				g.drawImage(((ImagenGrafico)objg).getImagen(), objg.getX(),
				objg.getY(), null);
			}
			else if (objg instanceof LineaGrafica) {
				g.setColor(((LineaGrafica) objg).getColor());
				int w = ((LineaGrafica) objg).getX1();
				int h = ((LineaGrafica) objg).getY1();
				((Graphics2D) g).setStroke(new BasicStroke(3));
				g.drawLine(objg.getX(), objg.getY(), w, h);

			}
			else { //Es un objeto de tipo TextoGrafico
				g.setColor(((TextoGrafico)objg).getColor());
				g.drawString(((TextoGrafico)objg).getTexto(),objg.getX(),objg.getY());
				}
		}
	}
}