package com.ATIVIDADE1;

import java.util.ArrayList;
import java.util.Scanner;

public class NewConsole {
    ArrayList<Estados> estados = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void controleMenu(char opcao){
        switch(opcao){
            case '1':
                novoEstado();
                break;
            case '2':
                atualizarEstado();
                break;
            case '3':
                listarEstados();
                break;
            case '4':
                buscarEstado();
                break;
            case '5':
                removerEstado();
                break;
            case '6':
                System.exit(0);
            default:
                System.out.println("Escolha uma opção válida!\n");
        }
    }
    
    public void menu(){
        char opcao;
        
        System.out.println("[1]. Novo Estado");
        System.out.println("[2]. Atualizar Estado");
        System.out.println("[3]. Listar estados");
        System.out.println("[4]. Buscar estado pelo DDD");
        System.out.println("[5]. Remover estado");
        System.out.println("[6]. Sair");
        System.out.print("|Escolha uma opção (1-6): ");
        opcao = input.next().charAt(0);
        
        input.nextLine();
        
        controleMenu(opcao);  
    }
    
    public void novoEstado(){
        System.out.print("\nInforme o nome do estado: ");
        String nomeEstado = input.nextLine();
        
        System.out.print("\nInforme o DDD do estado: ");
        String dddEstado = input.nextLine();
        
        Estados estado = new Estados(nomeEstado, dddEstado);
        
        System.out.println("\nEstado " + nomeEstado + " foi adicionado!\n");
        
        estados.add(estado);
    }
    
    public void atualizarEstado(){
        boolean encontrado = false;
        
        System.out.print("\nInforme o nome do estado: ");
        String nome = input.nextLine();
        
        for (int i = 0; i < estados.size(); i++) {
            if(nome.equalsIgnoreCase(estados.get(i).getEstado())){
                encontrado = true;
                
                System.out.print("\nInforme um novo nome para esse estado: ");
                String novoNome = input.nextLine();
                
                System.out.print("\nInforme um novo DDD para esse estado: ");
                String novoDdd = input.nextLine();
                
                estados.get(i).setEstado(novoNome);
                estados.get(i).setDdd(novoDdd);
                
                System.out.println("\nEstado atualizado!");
            }
        }
        if(!encontrado){
            System.out.println("Estado não encontrado!");
        }
    }
    
    public void listarEstados(){
        if(estados.isEmpty()){
            System.out.println("Não existem estados cadastrados!");
        }
        
        for (int i = 0; i < estados.size(); i++) {
            System.out.printf("\nEstado %d\n", i+1);
            System.out.println("Nome: " + estados.get(i).getEstado());
            System.out.println("DDD: " + estados.get(i).getDdd());
            System.out.println("--------------\n");
        }
    }
    
    public void buscarEstado(){
        boolean encontrado = false;
        
        System.out.print("\nInforme o DDD do estado: ");
        String ddd = input.nextLine();
        
        
        for (int i = 0; i < estados.size(); i++) {
            if(ddd.equalsIgnoreCase(estados.get(i).getDdd())){
                encontrado = true;
                
                System.out.println("\nEstado com DDD " + ddd + ": " + estados.get(i).getEstado() + "\n");
            }
        }
        if(!encontrado){
            System.out.println("Estado não encontrado!");
        }
    }
    
    public void removerEstado(){
        boolean encontrado = false;
        
        System.out.print("\nInforme o nome do estado: ");
        String nome = input.nextLine();
        
        for (int i = 0; i < estados.size(); i++) {
            if(nome.equalsIgnoreCase(estados.get(i).getEstado())){
                encontrado = true;
                
                estados.remove(i);
                System.out.println("\nEstado removido!");
            }
        }
        if(!encontrado){
            System.out.println("Estado não encontrado!");
        }
    }
 }

