package net.sgoliver.android.listview;

public class Alumno
{
	private String Apellidos;
	private String Nombre;
	private String Clase;
	private String Nivel;

	public Alumno(String apellidos, String nombre, String clase, String nivel) {
		Apellidos = apellidos;
		Nombre = nombre;
		Clase = clase;
		Nivel = nivel;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getClase() {
		return Clase;
	}

	public void setClase(String clase) {
		Clase = clase;
	}

	public String getNivel() {
		return Nivel;
	}

	public void setNivel(String nivel) {
		Nivel = nivel;
	}
}
