program fibo(input, output);
var NN: integer;
    debug: boolean;

procedure nacci(fn1, fn2, n: integer);
var fn: integer;
begin
    fn := fn1 + fn2;
    writeln('F_', n, ' = ', fn);
    if n < NN then
    begin
        nacci(fn, fn1, n+1)
    end
end;

begin
    NN := 23;
    debug := true;
    writeln('Fibonacci Numbers');
    writeln('F_1 = 1');
    writeln('F_2 = 1');
    nacci(1, 1, 3, 4)    { <<<< sematic error here }
end.
