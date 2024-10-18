package caju;

import java.util.ArrayList;
import java.util.List;

import caju.analysis.*;
import caju.node.*;

public class Semantico extends DepthFirstAdapter {
	// Pilha de tabelas hash <identificador, informações do identificador>
	private Stack<HashMap<String, SimboloInfo>> pilhaTabelaSimbolos = new Stack<>();

	@Override
	public void inStart(Start node)
	    {
		   System.out.println("-------------------------------------------------");
		   System.out.println("Iniciando análise semântica...");
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
			HashMap<String, SimboloInfo> tabelaSimbolos =  new HashMap<>();
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
			HashMap<String, SimboloInfo> tabelaSimbolos = pilhaTabelaSimbolos.peek();

			List<PAVar> variaveis = new ArrayList<PAVar>(node.getVariaveis());
			for (PAVar v : variaveis) {
				SimboloInfo simbolo = new SimboloInfo(node.getATipo(), false);
				tabelaSimbolos.put(v.toString(), simbolo);
			}
		}

	@Override 
	public void outAAAtribAAtrib(AAAtribAAtrib node)
	{
		
	}
	 
}
