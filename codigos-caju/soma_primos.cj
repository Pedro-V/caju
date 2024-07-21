{
  Programa para continuamente encontrar a soma dos primos num intervalo.
  Esse programa usa memoização para tal.
}
vetor numero[100000 + 1] memo.

-> numero meu_programa() inicio
  numero a, b.
  vetor numero[100000 + 1] primos.

  init_memo().

  exibir("Para qual intervalo de números você que a soma de primos?\n").
  exibir("Obs: Limites de intervalo entre 0 e 100000\n").

  enquanto (ler("%d %d" | a | b)) inicio
    primos := primosNoIntervalo(a | b).
    resultado := soma(primos).
    exibir("Resultado: %d\n" | resultado).
  fim

  retorne 0.
fim

# Converte numeros para booleanos.
booleano bool(numero n) inicio
  booleano b.

  se (n = 0) b := falso. senao b := true.

  retorne b.
fim

numero mod(numero a | numero b) inicio
  numero quociente.

  # Assume que é uma divisao inteira.
  quociente := div(a | b).
  retorne a - (quociente * b).
fim

booleano eh_primo(numero n) inicio
  numero i.

  se (n <= 1) retorne falso.
  se (nao (memo[n] = -1)) retorne bool(memo[n]).

  para (i := 2; i*i < n; i := i + 1)
    se (mod(n | i) = 0) inicio
      memo[n] := 0.
      retorne bool(memo[n]).
    fim

  memo[n] := 1.
  retorne bool(memo[n]).
fim

vazio init_memo() inicio
  numero i.
  para (i := 2; i <= 100000; i := i + 1)
    memo[i] := -1.
fim

vetor numero[100000 + 1] primosNoIntervalo(numero a | numero b) inicio
  numero i, idx.
  vetor numero[100000 + 1]

  idx := 0.
  para (i := a; i <= b; i := i + 1) inicio
    se (eh_primo(i)) primos[idx] := i. senao primos[idx] := 0.
    idx := idx + 1.
  fim
  
  retorne primos.
fim

numero soma(vetor numero[100000 + 1] xs) inicio
  numero soma.

  soma := 0.
  para cada (numero x : xs) soma := soma + x.
  retorne soma.
fim
