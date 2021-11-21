import javax.swing.JOptionPane;

public class Lista {
    Nodo head;

	public Lista() {
		head = null;
	}

    public void crearLista (){
        Nodo q = new Nodo();
		String [] leer = { "Si", "No"};
		int op;

        if(head == null){
            do{
                Nodo p = new Nodo();
				int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Leer dato: "));
                p.setDato(dato);
                p.setSig(null);
                if (head == null){
                    head = p;
                    p.setAnt(null);
                }
                else{
                    p.setAnt(q);
                    q.setSig(p);
                }
                q = p;
                op = JOptionPane.showOptionDialog (null, "Leer otro dato?", "Selecciona una opcion", 
                                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, leer, leer[0]);
            }while(op != 1);
        } else
            System.out.println("Lista vacia...");
    }

    public void recorrerLista(){
        Nodo p = new Nodo();
		int cont = 1;

		if (head != null){
			p = head;
			System.out.println("<=                                     =>");
			do{
				System.out.println("Posicion del nodo: "+cont+", Dato de nodo: "+p.getDato());
				p = p.getSig();
				cont++;
			}while(p != null);
		}
		else
			System.out.println("Lista vacia...");
    }

    public int tamanoLista() {
		Nodo p = new Nodo();
		int tam = 0;
		
		if (head != null){
			p = head;
			tam = 1;
			while(p.getSig() != null){
				p = p.getSig();
                tam++;
			}
		} else
			System.out.println("Lista vacia...");
		return tam;
	}

	public void insertarAlInicio(int dato){
		Nodo p = new Nodo();
        p.setDato(dato);
        p.setAnt(null);
		p.setSig(head);
        if(head != null)
            head.setAnt(p);
        head = p;
	}

	public void insertarAlFinal(int dato){
		Nodo q = new Nodo();
		Nodo p = new Nodo();

		p.setDato(dato);
		p.setSig(null);
		if(head != null){
			q = head;
			while(q.getSig() != null)
				q = q.getSig();
			q.setSig(p);
            p.setAnt(q);
		} else{
			head = p;
            p.setAnt(null);
		}
	}

	public void insertarEnPosicion(int pos){
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int c;

		p = head;
		c = 0;
		while(p != null){
			p = p.getSig();
			c++;
		}
		if(pos > 0 && pos <= c+1){
			p = new Nodo();
			int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Insertar dato: "));
			p.setDato(dato);
			if(pos == 1){
				p.setSig(head);
                p.setAnt(null);
                p.getSig().setAnt(p);
				head = p;
			} else {
				q = head;
				for(int i = 1; i < pos-1; i++)
					q = q.getSig();
				p.setSig(q.getSig());
                p.setAnt(q);
				q.setSig(p);
                if(p.getSig() != null)
                    p.getSig().setAnt(p);
			}
		} else
			System.out.println("Posicion incorrecta");
	}

	public void borrarUltimo(){
		Nodo p = new Nodo();

		if(head != null){
			p = head;
			while(p.getSig() != null)
				p = p.getSig();
			if(p == head)
                head = null;
			else
				p.getAnt().setSig(null);
		} else
			System.out.println("Lista vacia...");	
	}

	public void borraPrimero(){
        Nodo p = new Nodo();

		if(head != null){
            p = head;
			head = head.getSig();
            if(head != null)
                head.setAnt(null);
        } else
		    System.out.println("Lista vacia");	
	}

	public void borrarCualquier(int pos){
		Nodo p = new Nodo();
		int c = 0;

		if(head != null){
			p = head;
			c = 1;
			while(c != pos && p != null){
				p = p.getSig();
				c++;
			}
			if(c == pos){
				if(p == head){
					head = head.getSig();
                    if(head != null)
                        head.setAnt(null);
                } else{
					p.getAnt().setSig(p.getSig());
                    if(p.getSig() != null)
                        p.getSig().setAnt(p.getAnt());
                }
			} else
				System.out.println("Posicion invalida");
		} else
			System.out.println("Lista vacia");
	}

	public Nodo buscar(int dato){
		Nodo p = new Nodo();
		boolean existe;

		if (head != null){
			existe = false;
			p = head;
			while(p != null && existe != true){
				if (p.getDato() == dato)
					existe = true;
				else
					p = p.getSig();
			}
			if(existe == true){
				System.out.println("Se encontro el elemento");
				return p;
			}else{
				System.out.println("No se encontro el elemento");
				return null;
			}
		} else
			System.out.println("Lista vacia...");
		return null;
	}















    
}
