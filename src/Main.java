import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        Lista miLista = new Lista();

        int pos = 0, dato = 0;
        String menu = " ";
		String[] optionsMenu = {"Recorrer lista", "Tamano de la lista",
		 	"Insertar en el inicio", "Insertar en el final", "Insertar en posicion",
		 	"Borrar ultimo", "Borrar primero", "Borrar en posicion", "Buscar", "Salir"};
		
		JOptionPane.showMessageDialog(null, "-> Creacion de la Lista doble lineal <-");
		miLista.crearLista();
		
		while(menu != "Salir") {
            menu = (String) JOptionPane.showInputDialog(null, "Elige una opcion del menu",
			        "Menu", JOptionPane.QUESTION_MESSAGE, null, optionsMenu, optionsMenu[0]);
			
			if(menu == null)
				menu = "Salir";
			
			switch(menu) {
			
			case "Recorrer lista":
                miLista.recorrerLista();
				break;
				
			case "Tamano de la lista":
                JOptionPane.showMessageDialog(null, "El tamano de la lista es: "+miLista.tamanoLista());
				break;

			case "Insertar en el inicio":
                dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Insertar dato al inicio:"));
                miLista.insertarAlInicio(dato);
				break;
				
			case "Insertar en el final":
                dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Insertar dato al final:"));
                miLista.insertarAlFinal(dato);
				break;
				
			case "Insertar en posicion":
                pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar posicion para insertar dato:"));
                miLista.insertarEnPosicion(pos);
				break;

			case "Borrar ultimo":
                miLista.borrarUltimo();
				break;

			case "Borrar primero":
                miLista.borraPrimero();
				break;

			case "Borrar en posicion":
                pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar posicion para borrar nodo:"));
                miLista.borrarCualquier(pos);
				break;

			case "Buscar":
                dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar dato a buscar:"));
                Nodo n = miLista.buscar(dato);
                if(n != null){
                    JOptionPane.showMessageDialog(null, "El dato del Nodo encontrado => "+n.getDato()+" <="
						+", \nEl Nodo siguiente => "+n.getSig()+" <="
						+", \nEl Nodo anterior => "+n.getAnt()+" <=");
					//JOptionPane.showMessageDialog(null, "El dato del Nodo encontrado => "+n.getDato());
                } else
                    JOptionPane.showMessageDialog(null, "No se encontro el dato del Nodo.");
				break;
				
			case "Salir": // Mensaje despedida
				System.out.println("Decidiste salir del programa, hasta pronto!.");
				break;
			}
        }
    }
}
