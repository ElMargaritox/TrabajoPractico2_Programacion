package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private String nombre;
    private int codigo;
    private int stock;
    protected Scanner scanner;
    protected ArrayList<Producto> productos;


    public Producto(){
        scanner = new Scanner(System.in);
        productos = new ArrayList<>();
    }


    public void addProducto(String nombre, int codigo, int stock){
        try{
            Producto aux = new Producto();
            aux.nombre = nombre;
            aux.codigo = codigo;
            aux.stock = stock;
            productos.add(aux);
            System.out.println("Has agregado correctamente un producto");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void mostrarProductos(){
        try{
            for (Producto producto : productos){
                if(producto.stock < 10){
                    System.out.println("---------------------------------");
                    System.out.println("Nombre: " + producto.getNombre());
                    System.out.println("Codigo: " + producto.getCodigo());
                    System.out.println("Stock: " + producto.getStock());
                    System.out.println("---------------------------------");
                }
            }
        }catch(Exception e){
            System.out.println("No Se Pudieron Encontrar Datos");
        }
    }


    public void menu(){
        Boolean salir = false;

        do {
            int opcion = 0;
            try{
                System.out.println("--MENU--");
                System.out.println("1 - Agregar");
                System.out.println("2 - Mostrar");
                opcion = scanner.nextInt();
            }catch(Exception e){

            }
            finally {
                if(opcion == 1)addProducto(verifyNombre(), verifyCodigo(), verifyStock());
                else if(opcion == 2)mostrarProductos();
                else salir = true;
            }
        }while(!salir);
    }

    private String verifyNombre(){
        Boolean error = false;
        do {
            try{
                System.out.println("Ingresar Nombre Del Producto: ");
                String _nombre = scanner.next();
                return _nombre;
            }catch(Exception e){
                System.out.println("Has Ingresado Un Nombre Incorrecto");scanner = new Scanner(System.in);
            }
        }while (!error);
        return null;
    }

    private int verifyStock(){
        Boolean error = false;
        do {
            try{
                System.out.println(" Ingresar Stock  Del Producto: ");
                int _stock = scanner.nextInt();
                return _stock;
            }catch(Exception e){
                System.out.println("Has Ingresado Un Valor Incorrecto");scanner = new Scanner(System.in);
            }
        }while (!error);
        return 0;

    }

    private int verifyCodigo(){
        Boolean error = false;
        do {
            try{
                System.out.println("Ingresar Codigo Del Producto: ");
                int _codigo = scanner.nextInt();
                return _codigo;
            }catch(Exception e){
                System.out.println("Has Ingresado Un Valor Incorrecto");scanner = new Scanner(System.in);
            }
        }while (!error);
        return 0;
    }

    public int getStock(){
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
}
