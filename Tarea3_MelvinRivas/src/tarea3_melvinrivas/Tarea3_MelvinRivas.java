/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea3_melvinrivas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author l3306
 */
public class Tarea3_MelvinRivas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        int op = 0;
        ArrayList <Integer> Lista1 = new ArrayList();
        ArrayList <Integer> Lista2 = new ArrayList();
        ArrayList <Integer> Lista3 = new ArrayList();
        
        do{
        String [] opciones = {"Llenar lista 1-2 con randoms","Ordenar lista 1-2 ","Calcular lista 3 ","Realizar operacion ","Encontrar diferencia","Salir"};
        op = JOptionPane.showOptionDialog(null, "Gestion de listas", "Bienvenido", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, input);
        
        
        switch (op) {
            case 0: {
                Lista1.clear();
                Lista2.clear();
                
                for (int i = 0; i < 100; i++) {
                    Random random = new Random();
                    int dado = random.nextInt(1,100);
                    Lista1.add(dado);
                }
                for (int i = 0; i < 100; i++) {
                    Random random = new Random();
                    int dado = random.nextInt(1, 100);
                    Lista2.add(dado);
                }
         
                break;
            }
            case 1: {
                Collections.sort(Lista1);
                
                String mensaje = "Elementos de la ArrayList 1 :\n";
                for (int i = 0; i < Lista1.size(); i++) {
                    mensaje += Lista1.get(i) + ", ";

                }
                JOptionPane.showMessageDialog(null, mensaje, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);

               Collections.sort(Lista2);
                
                   String mensaje2 = "Elementos de la ArrayList 2 :\n";
                for (int i = 0; i < Lista2.size(); i++) {
                    mensaje2 += Lista2.get(i) + ", ";

                }
                JOptionPane.showMessageDialog(null, mensaje2, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);


                break;
            }
            case 2: {
                Lista3.clear();
                Lista3.addAll(Lista1);
                Lista2.addAll(Lista2);
                for (int i = 0; i < Lista3.size(); i++) {
                    int cont = 0;
                    int copia = Lista3.get(i);

                    for (int j = 1; j <= copia; j++) {
                        if (copia % j == 0) {
                            cont++;
                        }
                    }

                    if (cont != 2) {
                        Lista3.remove(i);
                        i--; 
                    }
                }
                String mensaje3 = "Elementos de la ArrayList 3 :\n";
                for (int i = 0; i < Lista3.size(); i++) {
                    mensaje3 += Lista3.get(i) + ", ";

                }
                JOptionPane.showMessageDialog(null, mensaje3, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            case 3: {
                int cont1= 0;
                int cont2= 0;
                int cont3= 0;
                
                for (int i = 0; i < Lista1.size(); i++) {

                    cont1 = cont1 + Lista1.get(i);
                }
                for (int i = 0; i < Lista2.size(); i++) {

                    cont2 = cont2 + Lista2.get(i);
                }
                for (int i = 0; i < Lista3.size(); i++) {

                    cont3 = cont3 + Lista3.get(i);
                }
                
                String[] operaciones123 = {"Lista 1-2", "Lista 1-3", "Lista 2-3"};
                int op3 = JOptionPane.showOptionDialog(null, "Selector de Lista", "Diferencias", 0, JOptionPane.QUESTION_MESSAGE, null, operaciones123, input);

                if (op3 == 0) {
                    int opoperaciones = op4();
                    int resultados = 0;
                    if (opoperaciones == 0) {
                        resultados = suma(cont1, cont2);
                    } else if (opoperaciones == 1) {
                        resultados = resta(cont1, cont2);
                    } else if (opoperaciones == 2) {
                        resultados = multi(cont1, cont2);
                    } else if (opoperaciones == 3) {
                        resultados = divi(cont1, cont2);
                    }
                     JOptionPane.showConfirmDialog(null,  "Resultado: "+resultados, "", JOptionPane.PLAIN_MESSAGE);
   
                } else if (op3 == 1) {
                                       int opoperaciones = op4();
                    int resultados = 0;
                    if (opoperaciones == 0) {
                        resultados = suma(cont1, cont3);
                    } else if (opoperaciones == 1) {
                        resultados = resta(cont1, cont3);
                    } else if (opoperaciones == 2) {
                        resultados = multi(cont1, cont3);
                    } else if (opoperaciones == 3) {
                        resultados = divi(cont1, cont3);
                    }
                     JOptionPane.showConfirmDialog(null, "Resultado: "+resultados, "", JOptionPane.PLAIN_MESSAGE);
   
                } else if (op3 == 2) {
                                       int opoperaciones = op4();
                    int resultados = 0;
                    if (opoperaciones == 0) {
                        resultados = suma(cont3, cont2);
                    } else if (opoperaciones == 1) {
                        resultados = resta(cont3, cont2);
                    } else if (opoperaciones == 2) {
                        resultados = multi(cont3, cont2);
                    } else if (opoperaciones == 3) {
                        resultados = divi(cont3, cont2);
                    }
                    JOptionPane.showConfirmDialog(null,  "Resultado: "+resultados, "", JOptionPane.PLAIN_MESSAGE);
   
                }
                
                break;
            }
            case 4: {
                String[] diferencias = {"Lista 1-2", "Lista 1-3", "Lista 2-3"};
                int op2 = JOptionPane.showOptionDialog(null, "Selector de Lista", "Diferencias", 0, JOptionPane.QUESTION_MESSAGE, null, diferencias, input);
                if (op2 == 0) {// Lista 1 y 2
                    
                    String mensaje = "Diferencias de Listas 1 :\n";
                    for (int i = 0; i < Lista1.size(); i++) {
                        boolean encontrado = false;

                        for (int j = 0; j < Lista2.size(); j++) {
                            if (Lista1.get(i).equals(Lista2.get(j))) {
                                encontrado = true;
                                break; 
                            }
                        }

                        if (!encontrado) {
                            mensaje += Lista1.get(i) + " ,";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);

                    String mensaje2 = "Diferencias de Listas 2 :\n";
                    for (int i = 0; i < Lista2.size(); i++) {
                        boolean encontrado = false;

                        for (int j = 0; j < Lista1.size(); j++) {
                            if (Lista2.get(i).equals(Lista1.get(j))) {
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            mensaje2 += Lista2.get(i) + " ,";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje2, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);

                    
                } else if (op2 == 1) {// Lista 1 y 3 

                    String mensaje = "Diferencias de Listas 1 :\n";
                    for (int i = 0; i < Lista1.size(); i++) {
                        boolean encontrado = false;

                        for (int j = 0; j < Lista3.size(); j++) {
                            if (Lista1.get(i).equals(Lista3.get(j))) {
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            mensaje += Lista1.get(i) + " ,";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);

                    String mensaje2 = "Diferencias de Listas 3 :\n";
                    for (int i = 0; i < Lista3.size(); i++) {
                        boolean encontrado = false;

                        for (int j = 0; j < Lista1.size(); j++) {
                            if (Lista3.get(i).equals(Lista1.get(j))) {
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            mensaje2 += Lista3.get(i) + " ,";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje2, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);

                    
                    
                } else if (op2 == 2) {//Lista 2 y 3 

                    
                           String mensaje = "Diferencias de Listas 2 :\n";
                    for (int i = 0; i < Lista2.size(); i++) {
                        boolean encontrado = false;

                        for (int j = 0; j < Lista3.size(); j++) {
                            if (Lista2.get(i).equals(Lista3.get(j))) {
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            mensaje += Lista2.get(i) + " ,";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);

                    String mensaje2 = "Diferencias de Listas 3 :\n";
                    for (int i = 0; i < Lista3.size(); i++) {
                        boolean encontrado = false;

                        for (int j = 0; j < Lista2.size(); j++) {
                            if (Lista3.get(i).equals(Lista2.get(j))) {
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            mensaje2 += Lista3.get(i) + " ,";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje2, "Elementos de la ArrayList", JOptionPane.INFORMATION_MESSAGE);

                    
                    
                }
                break;
            }
            case 5: {
                JOptionPane.showConfirmDialog(null, "Gracias por usar nuestro programa", "", JOptionPane.PLAIN_MESSAGE);
   
                break;
            }
        }
        }while (op != 5);
    }
    public static int suma(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int resta(int a, int b) {
        int c = a - b;
        return c;
    }

    public static int multi(int a, int b) {
        int c = a * b;
        return c;
    }

    public static int divi(int a, int b) {
        int c = a / b;
        return c;
    }
        
    public static int op4 () {
        Scanner input = new Scanner(System.in);
        String[] operaciones = {"Suma", "Resta", "Multiplicacion", "Division"};
        int op4 = JOptionPane.showOptionDialog(null, "Selector de Lista", "Diferencias", 0, JOptionPane.QUESTION_MESSAGE, null, operaciones, input);
        return op4;
    }
        
}
