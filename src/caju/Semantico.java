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
			// copia os simbolos da tabela hash do topo para a próxima tabela hash
			HashMap<String, SimboloInfo> tabelaSimbolosTopo = (HashMap<String, SimboloInfo>) pilhaTabelaSimbolos.peek();
			HashMap<String, SimboloInfo> newTabelaSimbolos =  (HashMap<String, SimboloInfo>) tabelaSimbolosTopo.clone();
			pilhaTabelaSimbolos.push(newTabelaSimbolos);
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
			// adiciona as variaveis a tabela de simbolos
			for (PAVar v : variaveis) {
				String keyArr[] = v.toString().split(" ");
				String key = keyArr[0];
				SimboloInfo simbolo = new SimboloInfo(node.getATipo().toString(), false);
				tabelaSimbolos.put(key, simbolo);
				System.out.println(key + " de tipo " + node.getATipo().toString() + "adicionado na tabela de simbolos");
			}
		}

	@Override 
	public void outAAAtribAAtrib(AAAtribAAtrib node)
	{
		HashMap<String, SimboloInfo> tabelaSimbolos = pilhaTabelaSimbolos.peek();
		String keyArr[] = node.getAVar().toString().split(" ");
		String key = keyArr[0];
		// se a variável foi declarada previamente
		if (tabelaSimbolos.containsKey(key)) {
			SimboloInfo simbolo = tabelaSimbolos.get(key);
			simbolo.valor_atribuido();
			tabelaSimbolos.put(key, simbolo);
		}
		// variável não foi declarada
		else {
			System.out.println("ERRO: " + node.getAVar().toString() + " não foi declarado");
		}
	}
	 
}
