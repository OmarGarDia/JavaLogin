package Controlador;

public class Constructor {
	
	private String nombre;
	private String contraseña;
	
	
  /*Constructores*/
	
	public Constructor() {
		
	}	
	
	public Constructor(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	/*Getter & Setter*/
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Constructor [nombre=" + nombre + ", contraseña=" + contraseña + "]";
	}
	
	
	
}
