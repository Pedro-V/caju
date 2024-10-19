package caju;

import java.util.ArrayList;
import java.util.List;

import caju.analysis.*;
import caju.node.*;

import java.util.HashMap;
import java.util.Stack;


public class Semantico extends DepthFirstAdapter {
	// Pilha de tabelas hash <identificador, informações do identificador>
	private Stack<HashMap<String, SimboloInfo>> pilhaTabelaSimbolos = new Stack<HashMap<String, SimboloInfo>>();

	@Override
	public void inStart(Start node)
	    {
		   System.out.println("-------------------------------------------------");
		   System.out.println("Iniciando análise semântica...");
		   HashMap<String, SimboloInfo> tabelaSimbolos =  new HashMap<String, SimboloInfo>();
		   pilhaTabelaSimbolos.push(tabelaSimbolos);
	    }
	
	@Override
	public void outStart(Start node)
	    {
		    System.out.println("-------------------------------------------------");
	        System.out.println("Fim da análise semântica");
	        System.out.println("-------------------------------------------------");
			  
	    }


	@Override 
	public void inAABlocoABloco(AABlocoABloco node)
		{
			HashMap<String, SimboloInfo> tabelaSimbolos =  new HashMap<String, SimboloInfo>();
			pilhaTabelaSimbolos.push(tabelaSimbolos);
		}

	@Override
	public void outAABlocoABloco(AABlocoABloco node)
		{
			pilhaTabelaSimbolos.pop();
		}

	@Override
	public void outAADecVariaveisADecVariavel(AADecVariaveisADecVariavel node)
		{
			HashMap<String, SimboloInfo> tabelaSimbolos = (HashMap<String, SimboloInfo>) pilhaTabelaSimbolos.peek();
			System.out.println("-------------------------------------------------");
			List<PAVar> variaveis = new ArrayList<PAVar>(node.getVariaveis());
			for (PAVar v : variaveis) {
				SimboloInfo simbolo = new SimboloInfo(node.getATipo().toString(), false);
				tabelaSimbolos.put(v.toString(), simbolo);
				System.out.println(v.toString() + "adicionado na tabela de simbolos");
			}
		}

	@Override 
	public void outAAAtribAAtrib(AAAtribAAtrib node)
	{
		HashMap<String, SimboloInfo> tabelaSimbolos = pilhaTabelaSimbolos.peek();
	}
	 
}
