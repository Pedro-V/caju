-> vazio bubblesort(vetor numero[tam] numeros | numero tam) inicio
    numero i.
    numero j.
    para(i := 0; i < tam-1; i := i+1) inicio
        para(j := 0; j < tam-1-i; j := j+1) inicio
            se (numeros[j+1] < numeros[j]) inicio 
                numero temp.
                temp := numeros[j].
                numeros[j] := numeros[j+1].
                numeros[j+1] := temp.
            fim
        fim 
    fim 
    retorne .
fim
