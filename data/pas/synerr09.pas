program testBasic(input, output);
var i: integer;
    a: array[1..10] of integer;
    msg: true;
    debug: boolean;

procedure printData;
var  i: integer;
begin
    i := 1;
    while i <= 10 do
    begin
        writeln(a[i]);
        i := i + 1
    end
end;

{ comment test here        }
{ begin for if end writeln }
{ i=1; i='a'; ..., ., : ;* }

begin
    debug := true;
    msg := 'D';
    writeln('***** calculating ******');
    i := 0;
    while i < 10 do
    begin
        i := i + 1;
        a[i] := i * i;
        if debug = true then       writeln('[', msg, '] i=', i) end  { <<<< syntax error here }
    end;
    writeln('***** result ******');
    printData
end.
