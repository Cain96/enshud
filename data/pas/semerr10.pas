program testBasic(input, output);
var i: integer;
    a: array[1..10] of integer;
    msg: char;
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
        i := i < debug   { <<<< sematic error here }
        i := i + 1;
        a[i] := i * i;
        begin
            if debug = true then begin writeln('[', msg, '] i=', i) end
        end
    end;
    writeln('***** result ******');
    printData
end.
