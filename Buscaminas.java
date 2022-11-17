package ejerciciosud4;

import java.util.Scanner;

public class Buscaminas {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		//Declaro dos variables que son la fila y la columna que introduce el usuario 
		int nFila,nCol;
		//Inicializo una variable de tipo int que sea el numero de filas
		int filas=5;
		int matriz[][]=rellenarMatriz(filas);
		//Pido al usuario que me introduzca un numero de fila
		System.out.println("Introduce la fila 0-4");
		nFila=sc.nextInt();
		//Hago lo mismo con las columnas
		System.out.println("Introduce la columna 0-4");
		nCol=sc.nextInt();
		//Llamo a la funcion numeroBombas para contar las bombas de alrededor de la posicion 
		int nBombas=numeroBombasAlredeor(nFila, nCol, matriz);
		System.out.print("Al rededor de la posicion ["+nCol+"] ["+nFila+"] ");
		System.out.println("hay "+nBombas+" bombas");
	}
	
	/*Hago una funcion en la cual el suario me rellene el array con - en caso de que
	 *  no halla bomba y * en caso de que halla bomba
	 */
	public static int[][] rellenarMatriz(int filas){
		/*Declaro una variable de tipo string que me vaya guardando lo que introduce el
		usuario*/
		String rellenar;
		//Inicializo una matriz de tipo int que me guarde 1 en caso de bomba  
		//y 0 en caso contrario. 
		int matriz[][]=new int [filas][filas];
		System.out.println("Introduce un * en caso de bomba");
		System.out.println("Introduce un - en caso de espacio en blanco");
		System.out.println();
		System.out.println();
		//Realizo un bucle para rellenar la matriz
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				//Pido al usuario que escriba un * en caso de bomba y un - en caso
				//de que no haya nada
				System.out.println("Introduce la coordenada ("+i+","+j+")");
				rellenar=sc.nextLine();
				//Hago un condicional para cambiar las bombas (*) por 1 y el resto por 0
				if(rellenar.equals("*")) {
					matriz[i][j]=1;
				}else matriz[i][j]=0;
			}
		}
		return matriz;
	}
	
	//Creo una funcion que me diga cuantas bombas hay alrededor de la posicion seleccionada
	//por el usuario.
	public static int numeroBombasAlredeor(int nFila, int nCol, int[][]matriz) {
		//creo un contador que cada vez que pase por una bomba sume uno
		int cont=0;
		for(int i=(nCol+1);i>=nCol-1;i--){
			/*Realizo un condicional en el cual si el numero es mayor o menor al 
			 * de la matriz, se salte ese numero.
			 * Hago lo mismo con las filas.
			 */
			if (i>=0&&i<=4) {
				for (int j=nFila+1;j>=nFila-1;j--) {
					if(j>=0&&j<=4) {
						//Si en la matriz hay un 1 suma uno al contador
						if(matriz[i][j]==1) {
							cont++;
						}
					}		
				}
			}
		}
				
		return cont;
	
	}
}
