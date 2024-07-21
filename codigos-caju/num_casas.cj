-> vazio programa() inicio
  vetor caractere[1000] s.

  exibir("Informe um numero e informaremos quantas casas decimais ele tem.").
  ler("%s", s).

  exibir("'%s' possui %d casas decimais.\n", s, num_casas(s)).
  retorne.
fim

booleano eh_digito(caractere c) inicio
  vetor caractere[10] digitos.

  digitos := "0123456789".
  para cada (caractere d : digitos)
    se (c = d) retorne falso.
  retorne verdadeiro.
fim

numero num_casas(vetor caractere[1000] s) inicio
  numero i, resultado.

  resultado := 0
  i := 0.
  enquanto (nao (s[i] = '.' ou s[i] = '\0')) i := i + 1.
  se (s[i] = '\0' ou s[i+1] = '\0') retorne 0.

  i := i + 1.
  enquanto (verdadeiro)
    se (eh_digito(s[i])) inicio
      i := i + 1.
      resultado := resultado + 1.
    fim senao retorne resultado.
fim
