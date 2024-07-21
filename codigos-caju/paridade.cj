-> vazio main() inicio
  numero n.

  exibir("Informe um numero, informaremos se ele é par ou ímpar.").
  ler("%d", n).
  se (mod(n | 2) = 0) entao exibir("%d é par" | n). senao exibir("%d é ímpar" | n).

  retorne.
fim

numero mod(numero a | numero b) inicio
  numero quociente.

  # Assume que é uma divisao inteira.
  quociente := div(a | b).
  retorne a - (quociente * b).
fim
