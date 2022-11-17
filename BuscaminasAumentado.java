package ejerciciosud4;

import java.util.Scanner;

public class BuscaminasAumentado {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		//Declaro dos variables que son la fila y la columna que introduce el usuario 
		int nFila,nCol;
		//Inicializo dos variables de tipo int que sea el numero de filas y
		//el contador de bombas
		int filas=5;
		int contador=0;
		String matriz[][]=new String[filas][filas];
		//Llamo al procedimiento menu donde tengo las instrucciones del juego
		menu();
		//Hago un bucle que se repita hasta que la matriz tenga 4 bombas.
		do{
			//Llamo a la matriz que está rellena
			String matrizRellena[][]=rellenarMatriz(filas);
			//Llamo a una funcion para comprobar el numero de bombas que hay en la matriz
			contador=comprobarBombas(matrizRellena);
			//Llamo a un procedimiento que iguale la matriz rellena a la matriz creada en el main
			igualarMatriz(matriz, matrizRellena);
			}while(contador!=4);
		//Hago un bucle que se repita hasta que me introduzca una pocscion con una bomba
		do{
		//Pido al usuario que me introduzca un numero de columna
		System.out.println("Introduce la columna 0-4");
		nCol=sc.nextInt();
		//Hago lo mismo con las filas
		System.out.println("Introduce la fila 0-4");
		nFila=sc.nextInt();
		//Llamo a la funcion numeroBombas para contar las bombas de alrededor de la posicion 
		int nBombas=numeroBombasAlredeor(nFila, nCol, matriz);
		//Muestro en pantalla el numero de bombas alrededor
		System.out.println(nBombas);
		}while(matriz[nFila][nCol]!="*");
		
		//Muestro el resultado en pantalla.
		System.out.println("\n");
		mostrarMatriz(matriz);

	}
	/*Hago una funcion que me rellene el array con - en caso de que no halla bomba y
	 *  * en caso de que halla bomba
	 */
	public static String[][] rellenarMatriz(int filas){
		String matriz[][]=new String [filas][filas];
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				int numAl=(int)(Math.random()*7);
				if(numAl==0) {
					matriz[i][j]="*";
				}else matriz[i][j]="-";
			}
		}
		return matriz;
	}
	
	//Hago una funcion que me compruebe el numero de bombas que hay
	public static int comprobarBombas(String[][] matriz){
		int cont=0;
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				if(matriz[i][j].equals("*")) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	//Hago un procedimiento que me iguale la matriz que esta rellena con la matriz
	//creado en el main
	public static void igualarMatriz(String [][] matriz, String [][]matriz2){
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				matriz[i][j]=matriz2[i][j];
			}
		}
	}
	
	//Creo una funcion que me diga cuantas bombas hay alrededor de la posicion seleccionada
	//por el usuario.
	public static int numeroBombasAlredeor(int nFila, int nCol, String[][]matriz) {
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
						//Si en la matriz hay un * suma uno al contador
						if(matriz[i][j]=="*") {
							cont++;
						}
					}		
				}
			}
		}
		return cont;
	
	}
	
	//Hago un procedimiento que muestre la matriz
	public static void mostrarMatriz(String [][]matriz){
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				System.out.printf("%-4s",matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	//Hago un procedimiento que muestre el menu del juego
	public static void menu () {
		System.out.println("++++++Reglas del juego++++++");
		System.out.println("Introduce la posicion en la que");
		System.out.println("está la bomba '*' hasta acertar");
		System.out.println("+++++++++++++++++++++++++++++");
	}
}
